package com.spotify.ui;

import com.spotify.dao.AlbumDao;
import com.spotify.dao.SongDao;
import com.spotify.model.Role;
import com.spotify.model.Song;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class MenuUI_homePage {

    public static void showMenu(Role userType, UUID artistId) {

        Scanner scanner = new Scanner(System.in);

        if (userType == Role.fromString("Artist")) {

            while (true) {
                System.out.println("\n|HOME PAGE|\nSELECT BY NUMBER: 0. Exit | 1. Search songs | 2. Liked songs | 3. See all your created songs | 4. Create a new album | 5. Link a song to an album");

                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                }

                switch (choice) {
                    case 1:
                        SearchUI.showMenu();
                        break;

                    case 2:
                        //MenuUI_LikedSongs.showmenu();
                        break;

                    case 3:
                        AddSong_AddAlbum_MenuUI.show_allSongs(artistId, (ArrayList<Song>) SongDao.getSongs());
                        break;

                    case 4:
                        AddSong_AddAlbum_MenuUI.show_addSongMenu(artistId, (ArrayList<Song>) SongDao.getSongs());
                        break;

                    case 5:
                        AddSong_AddAlbum_MenuUI.show_addAlbumMenu(artistId, AlbumDao.getAlbums());
                        break;

                    case 6:
                        AddSong_AddAlbum_MenuUI.show_addSongs_toAlbum_Menu(artistId, (ArrayList<Song>) SongDao.getSongs(), AlbumDao.getAlbums());
                }
            }
        } else {
            while (true) {
                System.out.println("|HOME PAGE|\nSELECT BY NUMBER: 0. Exit | 1. Search songs | 2. Liked songs");

                int choice = scanner.nextInt();
                if (choice == 0) {
                    break;
                }

                switch (choice) {
                    case 1:
                        SearchUI.showMenu();
                        break;

                    case 2:
                        //MenuUI_LikedSongs.showmenu();
                }
            }

        }
    }
}