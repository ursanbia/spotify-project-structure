package com.spotify.model;

import java.util.Random;

public class Album {

    private String albumName;
    private int id;
    private int artistId;

    public Album (String albumName){
        this.albumName = albumName;
        setId();
        this.id = getId();
    }

    public Album(int id, int artistId, String albumName) {
        setId();
        this.id = id;
        this.artistId = artistId;
        this.albumName = albumName;
    }

    public Album(String albumName, int artistId) {
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

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setId() {
        Random r = new Random( System.currentTimeMillis() );
        this.id = r.nextInt(10000);

    }

}

