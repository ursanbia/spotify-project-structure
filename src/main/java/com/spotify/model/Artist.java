package com.spotify.model;

import java.util.UUID;

public class Artist extends User{

    private String artistName;
    private  UUID artistId;

    public Artist(UUID artistId, String password, String email) {

         super(artistId, password, email);


    }

    public Artist() {

    }

    public Artist(UUID artistId, String artistName) {

        this.artistId = artistId;
        this.artistName = artistName;

    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }
}
