package com.spotify.service;

import com.spotify.dao.UserDao;
import com.spotify.model.User;

public class UserService {

    private UserDao userDao;

    public boolean login(String username, String password) {
//        User user = userDao.getUser(username, password);
//        if (user.isActive()) {
//            return true;
//        } else {
//            return false;
//        }
        return true;

    }


    public void singUp(String email, String password) {
        // verify user doesn't yet exist
        //persist user(inactiv)
        //confirmation email

        }

    public void confirm() {
        // confirm user -> active
    }



}
