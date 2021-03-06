package com.spotify.dao;

import com.spotify.model.Artist;
import com.spotify.model.Role;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ArtistDao {


    public static ArrayList<Artist> getArtists() {

        Path inputFile = Paths.get("src/main/resources/", "users.txt");

        try {
            List<String> artists = Files.readAllLines(inputFile);
            ArrayList<Artist> artistList = new ArrayList<Artist>();

            for (String info :
                    artists) {
                String[] userInfo = info.split(",");

                if (Role.fromString(userInfo[3]) == Role.Artist) {
                    //public Artist(UUID artistId, String email, String password, String artistName)
                    //System.out.println("\n"+userInfo[4]);
                    Artist artist = new Artist(UUID.fromString(userInfo[0]), userInfo[1], userInfo[2], userInfo[4]);
                    artistList.add(artist);
                }

            }

            return artistList;

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new ArrayList<Artist>();
    }

    public static Artist getArtist_byId(UUID artistId) {
        ArrayList<Artist> artistList = getArtists();

        for (Artist artist : artistList) {
            if (artistId.equals(artist.getId())) {
                return artist;
            }

        }
        return new Artist();
    }
}
