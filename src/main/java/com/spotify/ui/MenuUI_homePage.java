package com.spotify.ui;

import com.spotify.dao.AlbumDao;
import com.spotify.dao.SongDao;
import com.spotify.model.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI_homePage {

    public static void showMenu(int artistId) {
        System.out.println("\n|HOME PAGE|");
        System.out.println("1. Search songs");
        System.out.println("2. Liked songs");
        if (artistId != -1) {
            System.out.println("3. See all your songs");
            System.out.println("4. Add a new song");
            System.out.println("5. Add a new album");
            System.out.println("6. Link a song to an album");
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (artistId != -1) {
            switch (choice) {
                case 1:
                    //MenuUI_SearchSong.showmenu();
                    break;

                case 2:
                    //MenuUI_LikedSongs.showmenu();
                    break;

                case 3:
                    AddSong_AddAlbum_MenuUI.show_allSongs(1, (ArrayList<Song>) SongDao.getSongs());
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
        } else {
            switch (choice) {
                case 1:
                    //MenuUI_SearchSong.showmenu();
                    break;

                case 2:
                    //MenuUI_LikedSongs.showmenu();
            }
        }

    }
}