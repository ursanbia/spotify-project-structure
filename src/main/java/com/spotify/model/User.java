package com.spotify.model;

import java.util.UUID;

public class User {

    private UUID id;
    private String email;
    private String password;
    private Role userType;

    public User(UUID id, String password, String email, Role userType) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public User() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Role getUserType() {
        return userType;
    }

    public void setUserType(Role userType) {
        this.userType = userType;
    }

}
