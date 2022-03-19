package com.spotify.ui;

import com.spotify.model.Album;
import com.spotify.model.Song;
import com.spotify.service.AddSong_AddAlbum_Service;

public class AddSong_AddAlbum_Setter {

    public static Song setSongDetails(int artistId) {

        String songName = AddSong_AddAlbum_Getter.getSongName();
        String songDuration = AddSong_AddAlbum_Getter.getSongDuration();
        Song song = new Song(songName, songDuration, artistId);

        AddSong_AddAlbum_Service.addSongToFile(song);

        return song;
    }

    public static Album setAlbumDetails(int artistId) {

        String albumName = AddSong_AddAlbum_Getter.getSongAlbumName();
        Album album = new Album(albumName, artistId);

        AddSong_AddAlbum_Service.addAlbumToFile(album, artistId);

        return album;
    }

    public static void setSongstoAlbum(Album album, Song song) {

        song.setAlbum(album);

    }

}
