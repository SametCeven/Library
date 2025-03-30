package com.library.main;
import com.library.models.books.Book;
import com.library.models.core.Library;
import com.library.models.people.Librarian;
import java.util.Scanner;

public class SelectBookMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceSelectBookMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static Book selectedBook;

    public static void showSelectBookMenu(){
        System.out.println("--- Menu ---");
        System.out.println("1.Select Book by ID");
        System.out.println("2.Select Book by Name");
        System.out.println("3.Select Book by Author");

        if (scanner.hasNextInt()){
            choiceSelectBookMenu = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (choiceSelectBookMenu){
            case 1:




        }





    }

}
