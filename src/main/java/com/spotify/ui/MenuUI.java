package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.dao.AlbumDao;
import com.spotify.dao.SongDao;
import com.spotify.model.Song;
import com.spotify.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuUI<emails> {
    private UsersController usersController;

    public MenuUI() {
        usersController = new UsersController();
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("Please choose from the following menu options: ");
        System.out.println("1. SignUp");
        System.out.println("2. Login");

        choice = scanner.nextInt();

        switch (choice) {
            case 1: new SignUpUI().signUp();
                break;
            case 2: new LoginUI().login();
                break;
            default:
                System.out.println("Please pick a valid option");
        }
    }
}