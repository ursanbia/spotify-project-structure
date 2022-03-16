package com.spotify.controllers;

import com.spotify.model.User;
import com.spotify.service.UserService;

import java.util.List;

public class UsersController {

    private UserService userService;

    public UsersController() {
        userService = new UserService();
    }

    public List<User> getUsers() {
        return  userService.getAllUsers();
    }

    public void signUp(String email, String password) {
        userService.signUp(email, password);
    }

    public User login(String email, String password) {
        return userService.login(email, password);

    }
}
