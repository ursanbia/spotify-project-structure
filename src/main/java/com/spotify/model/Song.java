package com.spotify.model;

public class Song {

    private Album album;
    private int id;
    private String songName;
    private String songDuration;
    private Artist artist;

    public Song(String songName, String songDuration, Artist artist) {
        this.songName = songName;
        this.songDuration = songDuration;
        this.artist = artist;
        setId();
        this.id = getId();
    }

    public Song(Album album){
        this.album = album;
    }

    public int getId() {
        return id;
    }

    private static int i = 1;
    public void setId() {
        this.id = i;
        i++;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
