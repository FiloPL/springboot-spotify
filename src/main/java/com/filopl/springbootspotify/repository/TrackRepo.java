package com.filopl.springbootspotify.repository;

import com.filopl.springbootspotify.entity.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepo  extends MongoRepository<Track, String> {

}
