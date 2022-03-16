package com.spotify.ui;

public class MainUI {

    private MenuUI menuUI;

    public MainUI() {
        menuUI = new MenuUI();
    }

    public void showMain() {
        menuUI.showMenu();
    }
}
