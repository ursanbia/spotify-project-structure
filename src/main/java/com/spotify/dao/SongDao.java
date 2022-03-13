package com.spotify.dao;

import com.spotify.model.Song;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SongDao {

    public List<Song> getSongs() {

        Path inputFile = Paths.get("\\src\\main\\java\\com\\spotify\\model", "songs.txt");

        try {
            List<String> songs = Files.readAllLines(inputFile);
            ArrayList<Song> songList = new ArrayList<Song>();

            for (String melody :
                    songs) {
                String[] songInfo = melody.split(",");
                Song song = new Song(Integer.parseInt(songInfo[0]), songInfo[1], songInfo[2], Integer.parseInt(songInfo[3]));
                songList.add(song);
            }

            return songList;

        } catch(Exception ex) {
            System.out.println(ex);
        }
        return new ArrayList<Song>();
    }

}
