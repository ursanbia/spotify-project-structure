package com.spotify.dao;

import com.spotify.model.Role;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserDao {

    private UUID id;
    private String email;
    private Role userType;
    Path inputFile = Paths.get("src/main/resources/", "users.txt");

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    public Role getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public UserDao() {
    }

    public UserDao(UUID id, String email, String password, Role userType) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    private void createFileIfNotExists() {
        try {
            File yourFile = new File("users.txt");
            if (!yourFile.exists()) {
                yourFile.createNewFile();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List<UserDao> getUsers() {
        createFileIfNotExists();
        try {
            List<String> users = Files.readAllLines(inputFile);
            ArrayList<UserDao> userDaos = new ArrayList<UserDao>();

            for (String user :
                    users) {
                if (!user.equals("")) {
                    String[] userInfo = user.split(",");
                    UserDao userDao = new UserDao(UUID. fromString(userInfo[0]), userInfo[1], userInfo[2], Role.fromId(userInfo[3]));
                    userDaos.add(userDao);
                }
            }

            return userDaos;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new ArrayList<UserDao>();
    }

    public void saveUser(String email, String password, Role userType) {
        createFileIfNotExists();
        var userDao = new UserDao(UUID.randomUUID(),email, password, userType);

        try {
            String dao = "\n" + userDao.id + "," + userDao.email + "," + userDao.password + "," + userDao.userType.ordinal();
            Files.write(inputFile, dao.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public UserDao checkUserExist(String email, String password) {
        createFileIfNotExists();
        var existingUsers = this.getUsers();

        for (UserDao user :
                existingUsers) {
            if (user.email.equals(email) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }
}
