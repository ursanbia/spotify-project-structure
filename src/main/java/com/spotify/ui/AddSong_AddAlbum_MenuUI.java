package com.spotify.ui;

import com.spotify.model.Album;
import com.spotify.model.Song;
import com.spotify.service.AddSong_AddAlbum_Service;

import java.util.ArrayList;

public class AddSong_AddAlbum_MenuUI {

    public static void show_addSongMenu(int artistId, ArrayList<Song> songList) {

        Song song = AddSong_AddAlbum_Setter.setSongDetails(artistId); //show the "Add Song menu" and get/return the new object "Song" created by the artist
        AddSong_AddAlbum_Service.addSongToList(song, songList); //let's add the new object "Song" created by the artist to the current Song list
    }

    public static void show_addAlbumMenu(int artistId, ArrayList<Album> albumList) {

        //get an Album name from input
        Album album = AddSong_AddAlbum_Setter.setAlbumDetails(artistId);
        AddSong_AddAlbum_Service.addAlbumToList(album, albumList);

    }

    public static void show_addSongs_toAlbum_Menu(int artistId, ArrayList<Song> songList, ArrayList<Album> albumList) { //meniu in care artistul poate asocia Albume la Songs

        //arata o lista de Songs ale artistului care inca nu au setate un Album
        System.out.println("Here is a list of your Songs that you have not yet linked to an Album");
        ArrayList<Song> artist_songList_with_noAlbum = AddSong_AddAlbum_Service.generateListOf_Songs_thatHave_noAlbum(artistId, songList);
        AddSong_AddAlbum_Printer.printSongs_withoutAlbum(artist_songList_with_noAlbum);

        //arata o lista de albume realizate de artist
        //....

        //cere ID-ul al albumului in care sa se introduca melodiile
        //....

        //obtine obiectul Album prin albumId din input
        //....

        //cere o serie de ID-uri ale melodiilor care sa fie asociate cu albumul
        //....

        //obtine obiectele Songs prin songId din input
        //....

        //AddSong_AddAlbum_Setter.setSongstoAlbum(album, song);
    }

}
