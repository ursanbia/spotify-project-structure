package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.model.User;

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

                usersController.validateEmail(email);
                usersController.validatePassword(password);

                usersController.signUp(email, password);
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
                }

                break;

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
