package com.spotify.ui;

import com.spotify.model.Album;
import com.spotify.model.Song;
import com.spotify.service.Song_Album_Service;

import java.util.ArrayList;
import java.util.UUID;

public class Song_Album_MenuUI {

    public static void show_allSongs(UUID artistId, ArrayList<Song> songList) {
        //arata o lista de Songs ale artistului
        System.out.println("\n|Your songs|");
        ArrayList<Song> artist_songList = Song_Album_Service.generateListOf_Songs(artistId, songList);
        Song_Album_Printer.printSongs(artist_songList);
    }

    public static void show_addSongMenu(UUID artistId, ArrayList<Song> songList) {

        Song song = Song_Album_Setter.setSongDetails(artistId); //show the "Add Song menu" and get/return the new object "Song" created by the artist
        Song_Album_Service.addSongToList(song, songList); //let's add the new object "Song" created by the artist to the current Song list
    }

    public static void show_addAlbumMenu(UUID artistId, ArrayList<Album> albumList) {

        //get an Album name from input
        Album album = Song_Album_Setter.setAlbumDetails(artistId);
        Song_Album_Service.addAlbumToList(album, albumList);

    }

    public static void show_addSongs_toAlbum_Menu(UUID artistId, ArrayList<Song> songList, ArrayList<Album> albumList) { //meniu in care artistul poate asocia Albume la Songs


            //arata o lista de Songs ale artistului care inca nu au setate un Album
            System.out.println("\nHere is a list of your Songs that you have not yet linked to an Album");
            ArrayList<Song> artist_songList_with_noAlbum = Song_Album_Service.generateListOf_Songs_thatHave_noAlbum(artistId, songList);
            Song_Album_Printer.printSongs_withoutAlbum(artist_songList_with_noAlbum);

            //arata o lista de albume realizate de artist
            System.out.println("\nHere is a list of your Albums");
            ArrayList<Album> albumList_for_currentArtist = Song_Album_Service.generateListOf_Albums_for_currentArtist(artistId, albumList);
            Song_Album_Printer.printAlbums_titleOnly(albumList_for_currentArtist);

            //cere ID-ul al album-ului in care sa se introduca melodiile
            System.out.println("\nPlease insert the Album number in which you want to add your Songs.");
            int editedAlbumId = Song_Album_Getter.getAlbumId() - 1;

            //obtine obiectul Album prin albumId din input
            Album editedAlbum = albumList_for_currentArtist.get(editedAlbumId);

            //cere o serie de ID-uri ale melodiilor care sa fie asociate cu albumul si pune-le intr-o lista de Songs
            ArrayList<Song> songList_toBe_Edited = Song_Album_Getter.getSongList_toBeLinkedto_selectedAlbum(artist_songList_with_noAlbum, artistId);

            //modifica Album ID la lista de Songs
            ArrayList<Song> artists_songList_Edited_with_newAlbumId = Song_Album_Setter.setSongstoAlbum(songList_toBe_Edited, editedAlbum);
            songList = Song_Album_Service.edit_general_SongList_with_newAlbumId(songList, artists_songList_Edited_with_newAlbumId);
            Song_Album_Service.overwriteSongListInFile(songList);
        }
    }
