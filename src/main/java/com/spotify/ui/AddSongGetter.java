package com.spotify.ui;

import java.util.Scanner;

public class AddSongGetter {

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
}
