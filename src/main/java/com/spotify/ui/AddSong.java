package com.spotify.ui;

import com.spotify.model.Artist;
import com.spotify.model.Song;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AddSong {

    public static void showMenu (Artist artist) {
        AddSong.setSongDetails(artist);
    }

    public static void setSongDetails(Artist artist) {
        String songName = AddSongGetter.getSongName();
        String songDuration = AddSongGetter.getSongDuration();
        Song song = new Song(songName, songDuration, artist);

        addSongToFile(song);
    }

    public static void addSongToFile(Song song){
        Path inputFile = Paths.get("E:\\Java curs\\0. SPOTIFY\\spotify-project-structure\\src\\main\\java\\com\\spotify\\model", "songs.txt");
        try {
            String dao = "\n" + song.getId() + "," + song.getSongName() + "," + song.getSongDuration() + "," + song.getArtist();
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



}
