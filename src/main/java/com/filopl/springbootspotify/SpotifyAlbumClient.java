package com.filopl.springbootspotify;

import com.filopl.springbootspotify.entity.Track;
import com.filopl.springbootspotify.model.SpotifyAlbum;
import com.filopl.springbootspotify.model.dto.SpotifyAlbumDto;
import com.filopl.springbootspotify.repository.TrackRepo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@ResponseBody
public class SpotifyAlbumClient {

    private TrackRepo trackRepo;

    @GetMapping("/album/{authorName}")
    public SpotifyAlbum getAlbumsByAuthor(OAuth2Authentication details, @PathVariable String authorName) {
        String jwt = ((OAuth2AuthenticationDetails)details.getDetails()).getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<SpotifyAlbum> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q="+ authorName + "&type=track&market=US&limit=10&offset=5",
                HttpMethod.GET,
                httpEntity,
                SpotifyAlbum.class);

        List<SpotifyAlbumDto> spotifyAlbumDtos =
                exchange.getBody()
                    .getTracks().getItems().stream()
                    .map( item -> new SpotifyAlbumDto(item.getName(), item.getAlbum().getImages().get(0).getUrl()))
                    .collect(Collectors.toList());

        return (SpotifyAlbum) spotifyAlbumDtos;
    }

    @PostMapping("/add-track")
    public void addTrack(@RequestBody Track track) {
        trackRepo.save(track);
    }
}
