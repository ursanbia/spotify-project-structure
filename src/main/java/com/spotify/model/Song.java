package com.spotify.model;

public class Song {

    private Album album;
    private int id;
    private String songName;
    private String songDuration;
    private int artistId;

    public Song(String songName, String songDuration, int artistId) {
        this.songName = songName;
        this.songDuration = songDuration;
        this.artistId = artistId;
        setId();
        this.id = getId();
    }

    public Song(int id, String songName, String songDuration, int artistId) {
        this.id = getId();
        this.songName = songName;
        this.songDuration = songDuration;
        this.artistId = artistId;
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

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
