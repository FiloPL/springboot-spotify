package com.filopl.springbootspotify.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Track {

    private String id;
    private String trackName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }
}
