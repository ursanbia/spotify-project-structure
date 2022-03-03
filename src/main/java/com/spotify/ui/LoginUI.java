package com.spotify.ui;

import com.spotify.controllers.LoginControllers;

public class LoginUI {

    private LoginControllers loginControllers;

    public void login() {
        System.out.println("1. Username");
        //String username = read from keyboard username
        System.out.println("2. Password");
        // String password = read from keyboard password

        loginControllers.login("usernaem", "password");
    }
}
