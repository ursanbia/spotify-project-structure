package com.spotify.model;

import com.spotify.dao.AlbumDao;
import com.spotify.dao.ArtistDao;

import java.util.Random;
import java.util.UUID;

public class Song {

    private int id;
    private String songName;
    private String songDuration;
    UUID artistId;
    private int albumId;

    public Song(String songName, String songDuration, UUID artistId) {
        this.songName = songName;
        this.songDuration = songDuration;
        this.artistId = artistId;
       // this.artist = ArtistDao.getArtist_byId(artistId);
        setId();
        this.id = getId();
    }

    public Song(int id, UUID artistId, String songName, String songDuration, int albumId ) {
        setId();
        this.id = id;
        this.artistId = artistId;
        this.songName = songName;
        this.songDuration = songDuration;
        this.albumId = albumId;
//        this.album = AlbumDao.getAlbum_byId(albumId);
//        this.artist = ArtistDao.getArtist_byId(artistId);
    }

    public int getId() {
        return id;
    }

    public void setId() {
        Random r = new Random( System.currentTimeMillis() );
        this.id = r.nextInt(10000);
    }

//    public Album getAlbum() {
//        return album;
//    }
//
//    public void setAlbum(Album album) {
//        this.album = album;
//    }

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

    public UUID getArtistId() {
        return artistId;
    }

    public void setArtistId(UUID artistId) {
        this.artistId = artistId;
    }

//    public Artist getArtist() {
//        return artist;
//    }
//
//    public void setArtist(Artist artist) {
//        this.artist = artist;
//    }
}
