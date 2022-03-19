package com.spotify.service;

import com.spotify.model.Album;
import com.spotify.model.Song;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class AddSong_AddAlbum_Service {

    public static void addSongToFile(Song song){

        Path inputFile = Paths.get("src/main/resources/", "songs.txt");
        try {
            String dao = "\n" + song.getId() + "," + song.getSongName() + "," + song.getSongDuration() + "," + "NULL";
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addSongToList(Song song, ArrayList<Song> songList){

        songList.add(song); //add the Song to the song List

    }

    public static void addAlbumToFile(Album album, int artistId) {

        Path inputFile = Paths.get("src/main/resources/", "albums.txt");
        try {
            String dao = "\n" + album.getId() + "," + album.getArtistId() + "," +  album.getAlbumName();
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addAlbumToList(Album album, ArrayList<Album> albumList){

        albumList.add(album); //add the Song to the song List

    }

    public static ArrayList<Song> generateListOf_Songs_thatHave_noAlbum(int artistId, ArrayList<Song> songList){
        //returns a list of the artists' Songs that have not been linked an Album
        ArrayList<Song> artist_songList_with_noAlbum = new ArrayList<>();

        for (Song song : songList) {
            if (song.getArtistId() == artistId && song.getAlbum().getAlbumName() != "NULL") {
                artist_songList_with_noAlbum.add(song);
            }
        }
       return artist_songList_with_noAlbum;
    }

}
