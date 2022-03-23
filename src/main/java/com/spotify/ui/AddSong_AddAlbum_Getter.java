package com.spotify.ui;

import com.spotify.model.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class AddSong_AddAlbum_Getter {

    static Scanner keyboardScanner = new Scanner(System.in);

    public static String getSongName() {
        System.out.println("1. Please enter the Song name");
        String songName = keyboardScanner.nextLine();

        return songName;
    }

    public static String getSongDuration() {
        System.out.println("2. Please enter the Song duration in the correct format 'mm:ss' ");
        String songDuration = keyboardScanner.nextLine();

        return songDuration;
    }

    public static String getSongAlbumName() {
        System.out.println("Please enter the Album name");
        String albumName = keyboardScanner.nextLine();

        return albumName;
    }

    public static int getAlbumId() {
        int albumId = keyboardScanner.nextInt();

        return albumId;
    }

    public static ArrayList<Song> getSongList_toBeLinkedto_selectedAlbum(ArrayList<Song> songList, int artistId) {
        System.out.println("\nPlease insert the Song Id you want to link to the selected Album. You can link multiple Songs to the Album - just add each Id on a new line. When you are done just type '-1'");
        int userInput;
        ArrayList<Song> editedSongList = new ArrayList<>();

        do {
            userInput = keyboardScanner.nextInt();

            if (userInput == -1) {
                MenuUI_homePage.showMenu(artistId);
            } else {
                editedSongList.add(songList.get(userInput - 1));
            }
        }
        while (userInput != -1);
        return editedSongList;
    }


}
