package com.spotify;

import com.spotify.model.Song;
import com.spotify.ui.MainUI;

import java.util.ArrayList;

public class Application {

    static ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args){
        new MainUI().showMain();
    }
}
