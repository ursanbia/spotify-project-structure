package com.spotify.ui;

import com.spotify.dao.AlbumDao;
import com.spotify.dao.ArtistDao;
import com.spotify.model.Album;
import com.spotify.model.Artist;
import com.spotify.model.Song;

import java.util.ArrayList;

public class AddSong_AddAlbum_Printer {

    public static void printSongs_withoutAlbum(ArrayList<Song> songList) {
        int i = 1;
        for (Song song : songList) {
            System.out.println(i + ") '" + song.getSongName() + "'");
            i++;
        }
    }

    public static void printAlbums_titleOnly(ArrayList<Album> albumList) {
        int i = 1;
        for (Album album : albumList) {
            System.out.println(i + ") '" + album.getAlbumName() + "'");
            i++;
        }
    }

    public static void printSongs(ArrayList<Song> artist_songList) {
        int i = 1;
        for (Song song : artist_songList) {
            Artist artist = ArtistDao.getArtist_byId(song.getArtistId());
            if (song.getAlbumId() != -1) {
                Album album = AlbumDao.getAlbum_byId(song.getAlbumId());
                System.out.println(i + ") '" + song.getSongName() + "', " + song.getSongDuration() + " by '" + artist.getArtistName() + "' from album '" + album.getAlbumName() + "'");
            } else {
                System.out.println(i + ") '" + song.getSongName() + "', " + song.getSongDuration() + " by '" + artist.getArtistName() + "'");
                i++;
            }
        }
    }
}

