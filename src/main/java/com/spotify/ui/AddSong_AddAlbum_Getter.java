package com.spotify.ui;

import java.util.Scanner;

public class AddSong_AddAlbum_Getter {

    static Scanner keyboardScanner = new Scanner(System.in);

    public static String getSongName() {
        System.out.println("1. Please enter the Song name");
        String songName = keyboardScanner.next();

        return  songName;
    }

    public static String getSongDuration() {
        System.out.println("2. Please enter the Song duration in the correct format 'mm:ss' ");
        String songDuration = keyboardScanner.next();

        return  songDuration;
    }

    public static String getSongAlbumName() {
        System.out.println("Please enter the Album name");
        String songAlbumName = keyboardScanner.next();

        return  songAlbumName;
    }
}