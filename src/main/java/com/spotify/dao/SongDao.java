package com.spotify.dao;

import com.spotify.model.Song;
import jdk.swing.interop.SwingInterOpUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SongDao {

    public static List<Song> getSongs() {

        Path inputFile = Paths.get("src/main/resources/", "songs.txt");

        try {
            List<String> songs = Files.readAllLines(inputFile);
            ArrayList<Song> songList = new ArrayList<Song>();

            for (String melody :
                    songs) {
                String[] songInfo = melody.split(",");
                Song song = new Song(Integer.parseInt(songInfo[0]), UUID.fromString(songInfo[1]), songInfo[2], songInfo[3], Integer.parseInt(songInfo[4]));
              //  System.out.println(UUID.fromString(songInfo[1]) + "\n");
                songList.add(song);
            }

            return songList;

        } catch(Exception ex) {
            System.out.println(ex);
        }
        return new ArrayList<Song>();
    }



}
