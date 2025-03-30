package com.library.main;

import com.library.menus.LoginMenu;

public class Main {
    public static void main(String[] args) throws Exception {

        InitialData.createLibraryWithInitialData();
        LoginMenu.showLoginMenu();

    }
}