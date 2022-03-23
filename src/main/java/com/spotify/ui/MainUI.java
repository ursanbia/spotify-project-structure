package com.spotify.ui;

import java.io.IOException;

public class MainUI {

    private MenuUI menuUI;

    public MainUI() {
        menuUI = new MenuUI();
    }

    public void showMain() {
        menuUI.showMenu();
    }
}
