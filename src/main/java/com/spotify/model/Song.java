package com.spotify.model;

import com.spotify.dao.AlbumDao;

import java.util.Random;

public class Song {

    private Album album;
    private int id;
    private String songName;
    private String songDuration;
    private int artistId;
    private int albumId;

    public Song(String songName, String songDuration, int artistId) {
        this.songName = songName;
        this.songDuration = songDuration;
        this.artistId = artistId;
        setId();
        this.id = getId();
    }

    public Song(int id, int artistId, String songName, String songDuration, int albumId ) {
        setId();
        this.id = id;
        this.artistId = artistId;
        this.songName = songName;
        this.songDuration = songDuration;
        this.albumId = albumId;
        this.album = AlbumDao.getAlbum_byId(albumId);
    }

    public int getId() {
        return id;
    }

    public void setId() {
        Random r = new Random( System.currentTimeMillis() );
        this.id = r.nextInt(10000);
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
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
