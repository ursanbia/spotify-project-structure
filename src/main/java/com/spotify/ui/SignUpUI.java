package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.model.Role;

import java.util.Scanner;

public class SignUpUI {
    private UsersController usersController;

    public SignUpUI() {
        usersController = new UsersController();
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== SignUp page ==========");

        System.out.println("email: ");
        String email = scanner.next();

        System.out.println("password: ");
        String password = scanner.next();

        boolean isMailValid = this.usersController.validateEmail(email);
        boolean isPasswordValid = this.usersController.validatePassword(password);

        if (isMailValid && isPasswordValid) {

            System.out.println("Please select from user types: \n 0. Artist\n 1. User");
            int userTypeInteger = scanner.nextInt();
            String userTypeString;
            String artistName = "-";

            if (userTypeInteger == 0) {
                userTypeString = "Artist";
                System.out.println("What is your artist name: ");
                artistName = scanner.next();
            } else {
                userTypeString = "User";
            }

            Role role = Role.fromString(userTypeString);
            this.usersController.signUp(email, password, role, artistName);
           // new LoginUI();
           // LoginUI.login();
        }
    }
}
