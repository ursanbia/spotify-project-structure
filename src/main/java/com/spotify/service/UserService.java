package com.spotify.service;

import com.spotify.dao.UserDao;
import com.spotify.model.User;
import com.spotify.model.Role;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public List<User> getAllUsers() {
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

    public void signUp(String email, String password, Role userType) {
        userDao.saveUser(email, password, userType);
    }

    public User login(String email, String password) {
        var existingUser = userDao.checkUserExist(email, password);
        if (existingUser == null) {
            return null;
        }
        var user = new User();
        user.setId(existingUser.getId());
        user.setEmail(existingUser.getEmail());
        user.setPassword(existingUser.getPassword());
        user.setUserType(existingUser.getUserType());
        return user;
    }
}
