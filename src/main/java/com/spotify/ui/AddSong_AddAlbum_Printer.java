package com.spotify.ui;

import com.spotify.model.Album;
import com.spotify.model.Song;

import java.util.ArrayList;

public class AddSong_AddAlbum_Printer {

    public static void printSongs_withoutAlbum(ArrayList<Song> songList) {
        int i = 1;
        for (Song song : songList) {
            System.out.println(i + ") '" + song.getSongName() +"'");
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
            if (song.getAlbumId() != -1) {
                System.out.println(i + ") '" + song.getSongName() + "', " + song.getSongDuration() + " from album '" + song.getAlbum().getAlbumName() + "'");
            } else {
                System.out.println(i + ") '" + song.getSongName() + "', " + song.getSongDuration());
            }
            i++;
        }
    }
}
