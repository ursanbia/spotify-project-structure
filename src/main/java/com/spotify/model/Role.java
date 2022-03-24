package com.spotify.model;

public enum Role {

    Artist,
    User;

    public static Role fromString(String role) {
        switch (role) {
            case "Artist":
                return Role.Artist;
            case "User":
                return Role.User;
            default:
                return null;
        }
    }
}
