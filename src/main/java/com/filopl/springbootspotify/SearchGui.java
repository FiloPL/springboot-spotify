package com.filopl.springbootspotify;

import com.filopl.springbootspotify.model.SpotifyAlbum;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.client.RestTemplate;

@Route
public class SearchGui extends VerticalLayout {

    @Autowired
    public SearchGui(SpotifyAlbumClient spotifyAlbumClient) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject("/album/taylor@20swift", SpotifyAlbum.class);


    }

}
