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

        Path inputFile = Paths.get("\\src\\main\\java\\com\\spotify\\model", "songs.txt");
        try {
            String dao = "\n" + song.getId() + "," + song.getSongName() + "," + song.getSongDuration() + "," + song.getArtistId();
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void addSongToList(Song song, ArrayList<Song> songList){

        songList.add(song); //add the Song to the song List

    }

    public static Album addAlbum(String songAlbumName) {

        //let's create a new Album using the album name from input
        Album album = new Album(songAlbumName);

        return album;
    }

}
