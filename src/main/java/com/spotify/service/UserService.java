package com.spotify.service;

import com.spotify.dao.UserDao;
import com.spotify.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserDao userDao;

    public List<User> getAllUsers() {
        var userDao = new UserDao();
        var usersDaos = userDao.getUsers();
        var users = new ArrayList<User>();

        for (UserDao dao :
                usersDaos) {
            var user = new User();
            user.setId(dao.getId());
            user.setEmail(dao.getEmail());
            user.setPassword(dao.getPassword());
            users.add(user);
        }
        return users;
    }

    public void signUp(String email, String password) {
        var userDao = new UserDao();
        userDao.saveUser(email, password);
    }
}
