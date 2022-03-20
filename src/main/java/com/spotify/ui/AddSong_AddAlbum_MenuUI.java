package com.spotify.ui;

import com.spotify.model.Album;
import com.spotify.model.Song;
import com.spotify.service.AddSong_AddAlbum_Service;

import java.io.IOException;
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

    public static void show_addSongs_toAlbum_Menu(int artistId, ArrayList<Song> songList, ArrayList<Album> albumList)  { //meniu in care artistul poate asocia Albume la Songs

        //arata o lista de Songs ale artistului care inca nu au setate un Album
        System.out.println("\nHere is a list of your Songs that you have not yet linked to an Album");
        ArrayList<Song> artist_songList_with_noAlbum = AddSong_AddAlbum_Service.generateListOf_Songs_thatHave_noAlbum(artistId, songList);
        AddSong_AddAlbum_Printer.printSongs_withoutAlbum(artist_songList_with_noAlbum);

        //arata o lista de albume realizate de artist
        System.out.println("\nHere is a list of your Albums");
        ArrayList<Album> albumList_for_currentArtist = AddSong_AddAlbum_Service.generateListOf_Albums_for_currentArtist(artistId, albumList);
        AddSong_AddAlbum_Printer.printAlbums_titleOnly(albumList_for_currentArtist);

        //cere ID-ul al album-ului in care sa se introduca melodiile
        System.out.println("\nPlease insert the Album number in which you want to add your Songs");
        int editedAlbumId = AddSong_AddAlbum_Getter.getAlbumId() - 1;

        //obtine obiectul Album prin albumId din input
        Album editedAlbum = albumList_for_currentArtist.get(editedAlbumId);

        //cere o serie de ID-uri ale melodiilor care sa fie asociate cu albumul si pune-le intr-o lista de Songs
        ArrayList<Song> songList_toBe_Edited = AddSong_AddAlbum_Getter.getSongList_toBeLinkedto_selectedAlbum(artist_songList_with_noAlbum);

        //modifica Album ID la lista de Songs
        ArrayList<Song> artists_songList_Edited_with_newAlbumId = AddSong_AddAlbum_Setter.setSongstoAlbum(songList_toBe_Edited, editedAlbum);
        songList = AddSong_AddAlbum_Service.edit_general_SongList_with_newAlbumId(songList, artists_songList_Edited_with_newAlbumId);
        AddSong_AddAlbum_Service.overwriteSongListInFile(songList);
    }

}
