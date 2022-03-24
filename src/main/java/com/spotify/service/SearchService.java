package com.spotify.service;

import com.spotify.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public static ArrayList<Song> generateListOf_Songs_thatContain_searchInput(String searchInput, List<Song> songList) {
        //returns a list of Songs that contain Song name, Album name or Artist name from the searchInput word
        ArrayList<Song> songList_whichMached_searchInput = new ArrayList<>();

        for (Song song : songList) {
            if (song.getSongName().contains(searchInput)
                  //  (song.getAlbum() != null && song.getAlbum().getAlbumName().equalsIgnoreCase(searchInput)) ||
                  //  (song.getArtist() != null && song.getArtist().getArtistName().equalsIgnoreCase(searchInput))
            ) {
                songList_whichMached_searchInput.add(song);
            }

        }

        return songList_whichMached_searchInput;

    }
}
