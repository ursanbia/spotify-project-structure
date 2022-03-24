package com.spotify.ui;

import java.util.Scanner;

public class Search_Getter {

    static Scanner keyboardScanner = new Scanner(System.in);

    public static String getSearched() {
        System.out.println("Please enter the Song name, Artist name or the Album name that you are searching for");
        String search = keyboardScanner.nextLine();

        return search;
    }
}
