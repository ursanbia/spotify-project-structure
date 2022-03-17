package com.spotify.dao;

import com.spotify.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserDao {

    private int id;
    private String email;
    Path inputFile = Paths.get("~/spotify-project-structure/src/main/java/com/spotify/dao", "users.txt");

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public UserDao() {}

    public UserDao(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public List<UserDao> getUsers() {
        try {
            List<String> users = Files.readAllLines(inputFile);
            ArrayList<UserDao> userDaos = new ArrayList<UserDao>();

            for (String user :
                    users) {
                String[] userInfo = user.split(",");
                UserDao userDao = new UserDao(Integer.parseInt(userInfo[0]), userInfo[1], userInfo[2]);
                userDaos.add(userDao);
            }

            return userDaos;
        } catch(Exception ex) {
            System.out.println(ex);
        }
        return new ArrayList<UserDao>();
    }

    public void saveUser(String email, String password) {
        var userDao = new UserDao(new Random().nextInt(5) + 1, email, password);

        try {
            String dao = "\n" + userDao.id + "," + userDao.email + "," + userDao.password;
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public UserDao checkUserExist(String email, String password) {
        var existingUsers = this.getUsers();

        for (UserDao user :
                existingUsers) {
            if (user.email == email && user.password == password) {
                return user;
            }
        }
        return null;
    }
}
