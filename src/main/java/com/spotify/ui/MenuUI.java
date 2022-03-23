package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.dao.AlbumDao;
import com.spotify.dao.SongDao;
import com.spotify.model.Song;
import com.spotify.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuUI<emails> {
    private UsersController usersController;

    public MenuUI() {
        usersController = new UsersController();
    }

    public void showMenu() {
        System.out.println("Pick your choice:  ");
        System.out.println("1. Show all users" + "\n" + "2. SignUp");
        System.out.println("3. Login");

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
                    int artistId = -1;
                    //DACA E ARTIST INITIALIZEAZA artistID cu Id-ul userului, altfe artistId = -1;
                    MenuUI_homePage.showMenu(artistId);
                }
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
