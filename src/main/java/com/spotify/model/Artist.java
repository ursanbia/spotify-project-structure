package com.spotify.model;

import java.util.UUID;

public class Artist extends User {

    private String artistName;
    private UUID artistId;

    public Artist(UUID artistId, String email, String password, String artistName) {
         super(artistId, password, email, Role.Artist);
         this.artistName = artistName;
    }

    public Artist() {

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
