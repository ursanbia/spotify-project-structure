package com.spotify.service;

import com.spotify.model.Album;
import com.spotify.model.Song;

import java.util.ArrayList;

public class SearchService {

    public static ArrayList<Song> generateListOf_Songs_thatContain_searchInput(String searchInput, ArrayList<Song> songList) {
        //returns a list of Songs that contain Song name, Album name or Artist name from the searchInput word
        ArrayList<Song> songList_whichMached_searchInput = new ArrayList<>();

        for (Song song : songList) {
            System.out.println(song);
            if (song.getSongName().equalsIgnoreCase(searchInput)
                 //   (song.getAlbum() != null && song.getAlbum().getAlbumName().equalsIgnoreCase(searchInput)) ||
                 //   (song.getArtist() != null && song.getArtist().getArtistName().equalsIgnoreCase(searchInput))
             )
            {
                songList_whichMached_searchInput.add(song);
            }
            //NULL_POINT_EXCEPTION!!!!!!!!!!!!!!!!
        }

        return songList_whichMached_searchInput;

    }
}
