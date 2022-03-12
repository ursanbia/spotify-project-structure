package com.spotify.ui;

import java.util.Scanner;

public class UserUI<choice> {
    private String email;
    private String password;
    private UserType type;
    Scanner input = new Scanner(System.in);


    public UserUI(String email, String password, UserType type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
//    switch(choice)
//
//    {
//        case 1:
//            System.out.println("========== Simple User ==========");
//
//            System.out.print("email : ");
//            email = input.next();
//            System.out.print("password : ");
//            password = input.next();
//
//            SimpleUser.add(new User(email, password));
//            break;
//
//        case 2:
//            System.out.println("========== Artist ==========");
//
//            System.out.print("email : "); // input userType information (email, password ...)
//            email = input.next();
//            System.out.print("password : ");
//            password = input.next();
//
//
//            Artist.add(new User(email, password));
//            break;
//    }

}
