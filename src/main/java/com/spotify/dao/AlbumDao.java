package com.spotify.dao;

import com.spotify.model.Album;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AlbumDao {

    public static ArrayList<Album> getAlbums() {

        Path inputFile = Paths.get("src/main/resources/", "albums.txt");

        try {
            List<String> songs = Files.readAllLines(inputFile);
            ArrayList<Album> albumList = new ArrayList<Album>();

            for (String info :
                    songs) {
                String[] albumInfo = info.split(",");
                Album album = new Album(Integer.parseInt(albumInfo[0]), UUID.fromString(albumInfo[1]), albumInfo[2]);
                albumList.add(album);
            }

            return albumList;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new ArrayList<Album>();
    }

    public static Album getAlbum_byId(int albumId) {
        ArrayList<Album> albumList = getAlbums();
        for (Album album : albumList) {
            if (albumId == album.getId()) {
                return album;
            }

        }
        return new Album();
    }

}
