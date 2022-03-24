package com.spotify.model;

public enum Role {

    Artist,
    User;

    public static Role fromId(String role) {
        switch (role) {
            case "artist":
                return Role.Artist;
            case "user":
                return Role.User;
            default:
                return null;
        }
    }
}
