package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.dao.AlbumDao;
import com.spotify.dao.SongDao;
import com.spotify.model.Song;
import com.spotify.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MenuUI<emails> {
    private UsersController usersController;

    public MenuUI() {
        usersController = new UsersController();
    }

    public void showMenu() {
        System.out.println("Pick your choice:  ");
        System.out.println("1. Show all users" + "\n" + "2. SignUp");
        System.out.println("3. Login");
     //   System.out.println("4. ShowAll_artists_Songs- WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST");
     //   System.out.println("5. AddSongs- WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST");
     //   System.out.println("6. AddAlbum- WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST");
     //   System.out.println("7. AddSongsToAlbum - WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        String email = "";
        String password = "";

        switch (choice) {
            case 1:
                List<User> users = usersController.getUsers();
                printUsers(users);
                break;

            case 2:
                System.out.println("========== Please provide email & password ==========");
                System.out.println("email: ");
                email = scanner.next();
                System.out.println("password: ");
                password = scanner.next();
                boolean isMailValid = this.usersController.validateEmail(email);
                boolean isPasswordValid = this.usersController.validatePassword(password);
                if (isMailValid && isPasswordValid) {
                    this.usersController.signUp(email, password);
                }
                break;
            case 3:
                System.out.println("========== Please provide email & password ==========");
                System.out.println("email: ");
                email = scanner.next();
                System.out.println("password: ");
                password = scanner.next();

                var loggedUser = usersController.login(email, password);
                if (loggedUser == null) {
                    System.out.println("Invalid user credentials");
                } else {
                    System.out.println("login successful");
                    //...............................................................
                    boolean isArtist = true; //TREBUIE IMPLEMENTAT DACA USERUL E ARTIST SAU NU
                    //DACA E ARTIST ATUNCI isArtis e true; altfel, e false
                    //.........................................................
                    MenuUI_homePage.showMenu(loggedUser.getId(), isArtist);
                }
//            case 4:
//                AddSong_AddAlbum_MenuUI.show_allSongs(UUID.fromString("79c1d64a-3512-40a7-91f0-4e0df50392a6"), (ArrayList<Song>) SongDao.getSongs());
//                break;
////WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST
//            case 5:
//                AddSong_AddAlbum_MenuUI.show_addSongMenu(UUID.fromString("79c1d64a-3512-40a7-91f0-4e0df50392a6"), (ArrayList<Song>) SongDao.getSongs());
////WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST
//                break;
//            case 6:
//                AddSong_AddAlbum_MenuUI.show_addAlbumMenu(UUID.fromString("79c1d64a-3512-40a7-91f0-4e0df50392a6"), AlbumDao.getAlbums());
////WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST
//                break;
//            case 7:
//                AddSong_AddAlbum_MenuUI.show_addSongs_toAlbum_Menu(UUID.fromString("79c1d64a-3512-40a7-91f0-4e0df50392a6"), (ArrayList<Song>) SongDao.getSongs(), AlbumDao.getAlbums());
////WRONG POSITION HERE; TREBUIE UN ALT MENIU DUPA CE USERUL ESTE DEJA LOGAT; SI VA APAREA NUMAI DACA USERUL E ARTIST
            default:
                System.out.println("Please pick your account type");
        }
    }

    private void printUsers(List<User> users) {
        for (User user :
                users) {
            System.out.println("id:" + user.getId() + " email:" + user.getEmail() + " password:" + user.getPassword());
        }
    }
}
