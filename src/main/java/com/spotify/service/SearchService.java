package com.spotify.service;

import com.spotify.dao.AlbumDao;
import com.spotify.dao.ArtistDao;
import com.spotify.model.Album;
import com.spotify.model.Artist;
import com.spotify.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SearchService {

    public static ArrayList<Song> generateListOf_Songs_thatContain_searchInput(String searchInput, List<Song> songList) {
        //returns a list of Songs that contain Song name, Album name or Artist name from the searchInput word
        ArrayList<Song> songList_whichMached_searchInput = new ArrayList<>();

        for (Song song : songList) {
            Album album = AlbumDao.getAlbum_byId(song.getAlbumId());
            Artist artist = ArtistDao.getArtist_byId(song.getArtistId());
            if (song.getSongName().contains(searchInput) ||
                    (album.getAlbumName() != null && album.getAlbumName().contains(searchInput)) ||
                    (artist.getArtistName() != null && artist.getArtistName().contains(searchInput))
            ) {
                songList_whichMached_searchInput.add(song);
            }

        }

        return songList_whichMached_searchInput;

    }
}


//        for (Song song : artist_songList) {
//                Artist artist = ArtistDao.getArtist_byId(song.getArtistId());
//                if (song.getAlbumId() != -1) {
//                Album album = AlbumDao.getAlbum_byId(song.getAlbumId());
//                System.out.println(i + ") '" + song.getSongName() + "', " + song.getSongDuration() + " by '" + artist.getArtistName() + "' from album '" + album.getAlbumName() + "'");
//                } else {
//                System.out.println(i + ") '" + song.getSongName() + "', " + song.getSongDuration() + " by '" + artist.getArtistName() + "'");
//                i++;
//                }
//                }