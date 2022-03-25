package com.spotify.service;

import com.spotify.model.Album;
import com.spotify.model.Song;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.UUID;

public class Song_Album_Service {

    public static void addSongToFile(Song song) {

        Path inputFile = Paths.get("src/main/resources/", "songs.txt");
        try {
            String dao = "\n" + song.getId() + "," + song.getArtistId() + "," + song.getSongName() + "," + song.getSongDuration() + "," + "-1";
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void overwriteSongListInFile(ArrayList<Song> completeSongList) {

        Path inputFile = Paths.get("src/main/resources/", "songs.txt");

        try {
            PrintWriter writer = new PrintWriter(new File("src/main/resources/songs.txt"));
            writer.flush();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int i = 0;
        for (Song song : completeSongList) {
            try {
                String dao = null;
                if (i != 0) {
                    dao = "\n" + song.getId() + "," + song.getArtistId() + "," + song.getSongName() + "," + song.getSongDuration() + "," + song.getAlbumId();
                } else {
                    dao = song.getId() + "," + song.getArtistId() + "," + song.getSongName() + "," + song.getSongDuration() + "," + song.getAlbumId();
                }
                Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            i++;
        }
    }

    public static ArrayList<Song> edit_general_SongList_with_newAlbumId(ArrayList<Song> songList, ArrayList<Song> songList_toBe_Edited) {

        for (Song songEdited : songList_toBe_Edited) {
            for (Song song : songList) {
                if (songEdited.getId() == song.getId()) {
                    song.setAlbumId(songEdited.getAlbumId());
                }
            }
        }
        return songList;
    }

    public static void addSongToList(Song song, ArrayList<Song> songList) {

        songList.add(song); //add the Song to the song List

    }

    public static void addAlbumToFile(Album album) {

        Path inputFile = Paths.get("src/main/resources/", "albums.txt");
        try {
            String dao = "\n" + album.getId() + "," + album.getArtistId() + "," + album.getAlbumName();
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addAlbumToList(Album album, ArrayList<Album> albumList) {

        albumList.add(album); //add the Song to the song List

    }

    public static ArrayList<Song> generateListOf_Songs(UUID artistId, ArrayList<Song> songList) {
        //returns a list of the artists' Songs
        ArrayList<Song> artist_songList = new ArrayList<>();

        for (Song song : songList) {

            if (song.getArtistId().equals(artistId)) {
                artist_songList.add(song);
            }
            //NULL_POINT_EXCEPTION!!!!!!!!!!!!!!!!
        }

        return artist_songList;

    }


    public static ArrayList<Song> generateListOf_Songs_thatHave_noAlbum(UUID artistId, ArrayList<Song> songList) {
        //returns a list of the artists' Songs that have not been linked an Album
        ArrayList<Song> artist_songList_with_noAlbum = new ArrayList<>();

        for (Song song : songList) {

            if (song.getArtistId().equals(artistId) && song.getAlbumId() == -1) {
                artist_songList_with_noAlbum.add(song);
            }
            //NULL_POINT_EXCEPTION!!!!!!!!!!!!!!!!
        }

        return artist_songList_with_noAlbum;

    }

    public static ArrayList<Album> generateListOf_Albums_for_currentArtist(UUID artistId, ArrayList<Album> albumList) {
        ArrayList<Album> currentArtist_albumList = new ArrayList<>();

        for (Album album : albumList) {
            if (album.getArtistId().equals(artistId)) {
                currentArtist_albumList.add(album);
            }
            //NULL_POINT_EXCEPTION!!!!!!!!!!!!!!!!
        }
        return currentArtist_albumList;
    }


}
