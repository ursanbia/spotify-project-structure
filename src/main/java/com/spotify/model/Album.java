package com.spotify.model;

import java.util.Random;
import java.util.UUID;

public class Album {

    private String albumName;
    private int id;
    private UUID artistId;

    public Album (String albumName){
        this.albumName = albumName;
        setId();
        this.id = getId();
    }

    public Album(int id, UUID artistId, String albumName) {
        setId();
        this.id = id;
        this.artistId = artistId;
        this.albumName = albumName;
    }

    public Album(String albumName, UUID artistId) {
        setId();
        this.albumName = albumName;
        this.artistId = artistId;
    }

    public Album() {

    }

    public int getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }

    public void setId() {
        Random r = new Random( System.currentTimeMillis() );
        this.id = r.nextInt(10000);

    }

}

