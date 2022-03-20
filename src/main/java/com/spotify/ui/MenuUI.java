package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.dao.AlbumDao;
import com.spotify.dao.SongDao;
import com.spotify.model.Song;
import com.spotify.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUI {
    private UsersController usersController;

    public MenuUI() {
        usersController = new UsersController();
    }

    public void showMenu() {
        System.out.println("Pick your choice:  ");
        System.out.println("1. Show all users" + "\n" + "2. SignUp");
        System.out.println("3. Login");
        System.out.println("4. AddSongsTEST- WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST");
        System.out.println("5. AddAlbumTEST- WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST");
        System.out.println("6. AddSongsToAlbumTEST- WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        String email = "";
        String password = "";

        switch(choice) {
            case 1:
                List<User> users = usersController.getUsers();
                printUsers(users);
                break;

            case 2:
                System.out.println("========== Please provide email & password ==========");
                email = scanner.next();
                password = scanner.next();

                usersController.signUp(email, password);
                break;
            case 3:
                System.out.println("========== Please provide email & password ==========");
                email = scanner.next();
                password = scanner.next();

                var loggedUser = usersController.login(email, password);
                if (loggedUser == null) {
                    System.out.println("Invalid user credentials");
                } else {
                    System.out.println("login successful");
                }
            case 4:
                AddSong_AddAlbum_MenuUI.show_addSongMenu(1, (ArrayList<Song>) SongDao.getSongs());
//WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST
                break;
            case 5:
                AddSong_AddAlbum_MenuUI.show_addAlbumMenu(1, AlbumDao.getAlbums() );
//WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST
            case 6:
                AddSong_AddAlbum_MenuUI.show_addSongs_toAlbum_Menu(1, (ArrayList<Song>) SongDao.getSongs(), AlbumDao.getAlbums());
//WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST

            default:
                System.out.println("Please pick your account type");
        }
    }

    private void printUsers(List<User> users) {
        for (User user :
                users) {
            System.out.println("id:" + user.getId() + " email:" +  user.getEmail() + " password:" + user.getPassword());
        }
    }
}
