package com.spotify.ui;

import com.spotify.controllers.UsersController;
import com.spotify.model.User;

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

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                List<User> users = usersController.getUsers();
                printUsers(users);
            }
            case 2 -> {
                System.out.println("========== Please provide email & password ==========");
                String email = scanner.next();
                String password = scanner.next();
                usersController.signUp(email, password);
            }
            default -> System.out.println("Please pick your account type");
        }
    }

    private void printUsers(List<User> users) {
        for (User user :
                users) {
            System.out.println("id:" + user.getId() + " email:" +  user.getEmail() + " password:" + user.getPassword());
        }
    }
}
