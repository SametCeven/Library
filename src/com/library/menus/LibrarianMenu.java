package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.Journals;
import com.library.models.books.Magazines;
import com.library.models.books.Status;
import com.library.models.books.StudyBooks;
import com.library.models.core.Library;
import com.library.models.people.Author;

import java.text.ParseException;
import java.util.Scanner;


public class LibrarianMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int librarianChoice;

    public static void showLibrarianMenu() throws ParseException {
        System.out.println("\n--- Logged in as Librarian ---");
        System.out.println("--- Menu ---");
        System.out.println("1. Show books"); // id,isim,author
        System.out.println("2. Select book"); // update,delete,borrow,return
        System.out.println("3. Add book"); // add
        System.out.println("10. Exit");

        if (scanner.hasNextInt()){
            librarianChoice = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (librarianChoice){
            case 1:
                ShowBookMenu.showBookMenu();
                break;
            case 2:
                SelectBookMenu.showSelectBookMenu();
                break;
            case 3:
                System.out.println("Please enter book type (Journals,Magazines,StudyBooks)");
                scanner.nextLine();
                String bookType = scanner.nextLine();
                System.out.println("Please enter book id");
                Long bookId = scanner.nextLong();

                if(library.hasBook(bookId)){
                    System.out.println("Book ID already taken, try another ID");
                    break;
                }

                System.out.println("Please enter book author name");
                scanner.nextLine();
                String authorName = scanner.nextLine();
                System.out.println("Please enter book name");
                String bookName = scanner.nextLine();
                System.out.println("Please enter book price");
                Double price = scanner.nextDouble();
                System.out.println("Please enter book edition");
                scanner.nextLine();
                String edition = scanner.nextLine();

                if(bookType.equals("Magazines")) {
                    Magazines newbook = new Magazines(bookId,new Author(authorName),bookName,price, Status.AVAILABLE,edition);
                    library.addBook(newbook);
                }else if(bookType.equals("Journals")){
                    Journals newbook = new Journals(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition);
                    library.addBook(newbook);
                }else if(bookType.equals("StudyBooks")){
                    StudyBooks newbook = new StudyBooks(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition);
                    library.addBook(newbook);
                }
                break;

            case 10:
                break;
        }



    }





}
