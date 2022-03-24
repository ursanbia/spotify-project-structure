package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.model.UserTypeEnum;

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

        System.out.println("Please select from user types: \n 0. Artist\n 1. User");
        int userTypeInteger = scanner.nextInt();
        UserTypeEnum userType = UserTypeEnum.fromId(userTypeInteger);

        boolean isMailValid = this.usersController.validateEmail(email);
        boolean isPasswordValid = this.usersController.validatePassword(password);
        if (isMailValid && isPasswordValid) {
            this.usersController.signUp(email, password, userType);
            new LoginUI();
        }
    }
}
