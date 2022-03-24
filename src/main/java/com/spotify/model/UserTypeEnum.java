package com.spotify.model;

public enum UserTypeEnum {
    Artist,
    User;

    public static UserTypeEnum fromId(int id) {
        switch (id) {
            case 0:
                return UserTypeEnum.Artist;
            case 1: return UserTypeEnum.User;
            default:
                return null;
        }
    }
}
