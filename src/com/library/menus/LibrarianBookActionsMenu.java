package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.*;
import com.library.models.core.Library;
import com.library.models.people.Author;
import com.library.models.people.Librarian;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class LibrarianBookActionsMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceLibrarianBookActionsMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static Book selectedBook = SelectBookMenu.getSelectedBook();

    public static void showLibrarianBookActionsMenu() throws ParseException {
        System.out.println("--- Menu ---");
        System.out.println("1.Update Book Information");
        System.out.println("2.Delete Book");
        System.out.println("3.Add Book");
        System.out.println("4.Take Back Borrowed Book");
        System.out.println("5.Sell Book");

        if (scanner.hasNextInt()){
            choiceLibrarianBookActionsMenu = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (choiceLibrarianBookActionsMenu){
            case 1:
                UpdateBookInformationMenu.showUpdateBookInformationMenu();
                break;
            case 2:
                library.getBooksMap().remove(selectedBook.getBookId());
                break;
            case 3:
                System.out.println("Please enter book type (Journals,Magazines,StudyBooks)");
                String bookType = scanner.nextLine();
                System.out.println("Please enter book id");
                scanner.nextLine();
                Long bookId = scanner.nextLong();
                System.out.println("Please enter book author name");
                String authorName = scanner.nextLine();
                System.out.println("Please enter book name");
                String bookName = scanner.nextLine();
                System.out.println("Please enter book price");
                scanner.nextLine();
                Double price = scanner.nextDouble();
                System.out.println("Please enter book edition");
                String edition = scanner.nextLine();

                if(bookType.equals("Magazines")) {
                    Magazines newbook = new Magazines(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition);
                    library.addBook(newbook);
                }else if(bookType.equals("Journals")){
                    Journals newbook = new Journals(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition);
                    library.addBook(newbook);
                }else if(bookType.equals("StudyBooks")){
                    StudyBooks newbook = new StudyBooks(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition);
                    library.addBook(newbook);
                }
        }

    }
}
