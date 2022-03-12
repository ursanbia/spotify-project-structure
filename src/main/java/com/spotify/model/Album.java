package com.spotify.model;

public class Album {

    private String albumName;
    private int id;

    public Album (String albumName){
        this.albumName = albumName;
        setId();
        this.id = getId();
    }

    public int getId() {
        return id;
    }

    private static int i = 1;
    public void setId() {
        this.id = i;
        i++;
    }

}

