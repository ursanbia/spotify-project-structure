package com.spotify.ui;

import com.spotify.model.Album;
import com.spotify.model.Song;
import com.spotify.service.AddSong_AddAlbum_Service;

import java.util.ArrayList;
import java.util.UUID;

public class AddSong_AddAlbum_Setter {

    public static Song setSongDetails(UUID artistId) {

        String songName = AddSong_AddAlbum_Getter.getSongName();
        String songDuration = AddSong_AddAlbum_Getter.getSongDuration();
        Song song = new Song(songName, songDuration, artistId);

        AddSong_AddAlbum_Service.addSongToFile(song);

        return song;
    }

    public static Album setAlbumDetails(UUID artistId) {

        String albumName = AddSong_AddAlbum_Getter.getSongAlbumName();
        Album album = new Album(albumName, artistId);

        AddSong_AddAlbum_Service.addAlbumToFile(album);

        return album;
    }

    public static ArrayList<Song> setSongstoAlbum(ArrayList<Song> songList_toBeEdited, Album album) {

        for (Song song : songList_toBeEdited) {
            song.setAlbumId(album.getId());
        }

        return songList_toBeEdited;
    }

}
