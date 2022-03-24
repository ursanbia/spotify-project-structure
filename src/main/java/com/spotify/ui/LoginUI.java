package com.spotify.ui;

import com.spotify.controllers.UsersController;

import java.util.Scanner;

public class LoginUI {

    private static UsersController usersController;

    public LoginUI() {
        usersController = new UsersController();
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        String email;
        String password;

        System.out.println("========== Login page ==========");
        System.out.println("email: ");
        email = scanner.next();
        System.out.println("password: ");
        password = scanner.next();

        var loggedUser = usersController.login(email, password);
        if (loggedUser == null) {
            System.out.println("Invalid user credentials");
        } else {
            System.out.println("Welcome!");
            new MenuUI_homePage().showMenu(loggedUser.getUserType(), loggedUser.getId());
        }
    }
}