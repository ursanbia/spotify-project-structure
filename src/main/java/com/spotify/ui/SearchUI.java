package com.spotify.ui;

import com.spotify.dao.SongDao;
import com.spotify.model.Song;
import com.spotify.service.SearchService;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchUI {

    public static void showMenu() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n|SEARCH PAGE|\nSELECT BY NUMBER: 0. Exit | 1. Search songs by Name, Artist or Album");

            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice == 1) {//get the name of the song the user searched for
                String searchInput = Search_Getter.getSearched();

                //get a songList that contains all searchInput from all the Songs
                ArrayList<Song> generateListOf_Songs_thatContain_searchInput = SearchService.generateListOf_Songs_thatContain_searchInput(searchInput, SongDao.getSongs());

                //print get songList
                if (!generateListOf_Songs_thatContain_searchInput.isEmpty()) {
                    AddSong_AddAlbum_Printer.printSongs(generateListOf_Songs_thatContain_searchInput);
                }
                else System.out.println("Nothing found! Please retry!");
            }
        }
    }
}