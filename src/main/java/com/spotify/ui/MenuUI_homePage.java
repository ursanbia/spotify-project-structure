package com.spotify.ui;

import com.spotify.dao.AlbumDao;
import com.spotify.dao.SongDao;
import com.spotify.model.Song;
import com.spotify.model.UserTypeEnum;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuUI_homePage {

    public static void showMenu(UserTypeEnum userType, int artistId) {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (userType == UserTypeEnum.User) {
            System.out.println("\n|HOME PAGE|");
            System.out.println("1. Search songs");
            System.out.println("2. Liked songs");

            switch (choice) {
                case 1:
                    //MenuUI_SearchSong.showmenu();
                    break;

                case 2:
                    //MenuUI_LikedSongs.showmenu();
                    break;
            }

        } else {
            System.out.println("1. Add a new song");
            System.out.println("2. Add a new album");
            System.out.println("3. Link a song to an album");

            switch (choice) {
                case 1:
                    AddSong_AddAlbum_MenuUI.show_addSongMenu(artistId, (ArrayList<Song>) SongDao.getSongs());
                    break;

                case 2:
                    AddSong_AddAlbum_MenuUI.show_addAlbumMenu(artistId, AlbumDao.getAlbums());
                    break;

                case 3:
                    AddSong_AddAlbum_MenuUI.show_addSongs_toAlbum_Menu(artistId, (ArrayList<Song>) SongDao.getSongs(), AlbumDao.getAlbums());
            }
        }
    }
}