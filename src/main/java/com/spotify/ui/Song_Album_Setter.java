package com.spotify.ui;

import com.spotify.model.Album;
import com.spotify.model.Song;
import com.spotify.service.Song_Album_Service;

import java.util.ArrayList;
import java.util.UUID;

public class Song_Album_Setter {

    public static Song setSongDetails(UUID artistId) {

        String songName = Song_Album_Getter.getSongName();
        String songDuration = Song_Album_Getter.getSongDuration();
        Song song = new Song(songName, songDuration, artistId);

        Song_Album_Service.addSongToFile(song);

        return song;
    }

    public static Album setAlbumDetails(UUID artistId) {

        String albumName = Song_Album_Getter.getSongAlbumName();
        Album album = new Album(albumName, artistId);

        Song_Album_Service.addAlbumToFile(album);

        return album;
    }

    public static ArrayList<Song> setSongstoAlbum(ArrayList<Song> songList_toBeEdited, Album album) {

        for (Song song : songList_toBeEdited) {
            song.setAlbumId(album.getId());
        }

        return songList_toBeEdited;
    }

}
