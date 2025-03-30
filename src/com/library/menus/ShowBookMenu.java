package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.Book;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;
import com.library.models.people.Author;
import com.library.models.people.Librarian;
import com.library.models.people.Person;

import java.util.List;
import java.util.Scanner;


public class ShowBookMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int showBooksChoice;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static Person librarianUser = LoginMenu.getLibrarianUser();
    private static MemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showBookMenu(){
        if (librarianUser != null) System.out.println("--- Logged in as Librarian ---");
        else if (memberUser != null) System.out.println("--- Logged in as Member ---");
        System.out.println("--- Menu ---");
        System.out.println("1.Show All Books");
        System.out.println("2.Show Books by ID");
        System.out.println("3.Show Books by Name");
        System.out.println("4.Show Books by Author");
        System.out.println("5.Show Books by Member");

        if (scanner.hasNextInt()){
            showBooksChoice = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (showBooksChoice) {
            case 1:
                library.showLibraryBooks();
                break;
            case 2:
                System.out.println("Enter book ID");
                Long bookId = scanner.nextLong();
                Book bookFound2 = ((Librarian)librarian).searchBook(bookId);
                if(bookFound2 == null) System.out.println("Book not found");
                else bookFound2.showBook();
                break;
            case 3:
                System.out.println("Enter book name");
                scanner.nextLine();
                String bookName = scanner.nextLine();
                Book bookFound3 = ((Librarian)librarian).searchBook(bookName);
                if(bookFound3 == null) System.out.println("Book not found");
                else bookFound3.showBook();
                break;
            case 4:
                System.out.println("Enter author name");
                scanner.nextLine();
                String bookAuthor = scanner.nextLine();
                List<Book> bookFound4 = ((Librarian)librarian).searchBook(new Author(bookAuthor));
                System.out.println(bookFound4);
                if(bookFound4 == null) System.out.println("Book not found");
                else{
                    for(Book bookFound:bookFound4){
                        bookFound.showBook();
                    }
                }
                break;
            case 5:
                System.out.println("Enter member id");
                Long memberId = scanner.nextLong();
                library.getMemberRecordsMap().get(memberId).showMembersBooks();
        }
    }



}
