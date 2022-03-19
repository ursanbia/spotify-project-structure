package com.spotify.model;

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
        this.id = id;
        this.artistId = artistId;
        this.albumName = albumName;
    }

    public Album(String albumName, int artistId) {
        this.albumName = albumName;
        this.artistId = artistId;
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

    private static int i = 1;
    public void setId() {
        this.id = i;
        i++;
    }

}

