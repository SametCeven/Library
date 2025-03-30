package com.library.menus;
import com.library.main.InitialData;
import com.library.models.core.Library;

import java.text.ParseException;
import java.util.Scanner;


public class MemberMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int memberChoice;

    public static void showReaderMenu() throws ParseException {
        System.out.println("\n--- Logged in as Member ---");
        System.out.println("--- Menu ---");
        System.out.println("1. Show books"); // id,isim,author
        System.out.println("2. Select book"); // update,delete,borrow,return
        System.out.println("10. Exit");
        if (scanner.hasNextInt()){
            memberChoice = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (memberChoice){
            case 1:
                ShowBookMenu.showBookMenu();
                break;
            case 2:
                SelectBookMenu.showSelectBookMenu();
                break;
            case 10:
                break;
        }

    }







}
