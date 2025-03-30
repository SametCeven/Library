package com.library.main;
import com.library.models.core.Library;
import java.util.Scanner;


public class LibrarianMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int librarianChoice;

    public static void showLibrarianMenu(){
        System.out.println("\n--- Logged in as Librarian ---");
        System.out.println("--- Menu ---");
        System.out.println("1. Show books"); // id,isim,author
        System.out.println("2. Select book"); // update,delete,borrow,return
        System.out.println("10. Exit");
        if (scanner.hasNextInt()){
            librarianChoice = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (librarianChoice){
            case 1:
                BookMenu.showBookMenu();
            case 2:
                SelectBookMenu.showSelectBookMenu();
        }



    }





}
