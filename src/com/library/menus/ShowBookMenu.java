package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.AbstractBook;
import com.library.models.books.Status;
import com.library.models.core.Library;
import com.library.models.members.AbstractMemberRecord;
import com.library.models.people.Author;
import com.library.models.people.Librarian;
import com.library.models.people.AbstractPerson;

import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class ShowBookMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int showBooksChoice;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static AbstractPerson librarianUser = LoginMenu.getLibrarianUser();
    private static AbstractMemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showBookMenu(){
        librarianUser = LoginMenu.getLibrarianUser();
        memberUser = LoginMenu.getMemberUser();
        if (librarianUser != null) System.out.println("\n--- Logged in as Librarian ---");
        else if (memberUser != null) System.out.println("\n--- Logged in as Member ---");
        System.out.println("--- Menu ---");
        System.out.println("1.Show All Books");
        System.out.println("2.Show Books by ID");
        System.out.println("3.Show Books by Name");
        System.out.println("4.Show Books by Author");
        System.out.println("5.Show Books by Member");
        System.out.println("6.Show Available Books");
        System.out.println("7.Show Lent Books");
        System.out.println("8.Show Sold Books");
        System.out.println("10. Exit");

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
                AbstractBook abstractBookFound2 = ((Librarian)librarian).searchBook(bookId);
                if(abstractBookFound2 == null) System.out.println("Book not found");
                else abstractBookFound2.showBook();
                break;
            case 3:
                System.out.println("Enter book name");
                scanner.nextLine();
                String bookName = scanner.nextLine();
                AbstractBook abstractBookFound3 = ((Librarian)librarian).searchBook(bookName);
                if(abstractBookFound3 == null) System.out.println("Book not found");
                else abstractBookFound3.showBook();
                break;
            case 4:
                System.out.println("Enter author name");
                scanner.nextLine();
                String bookAuthor = scanner.nextLine();
                List<AbstractBook> abstractBookFound4 = ((Librarian)librarian).searchBook(new Author(bookAuthor));
                System.out.println(abstractBookFound4);
                if(abstractBookFound4 == null) System.out.println("Book not found");
                else{
                    for(AbstractBook abstractBookFound : abstractBookFound4){
                        abstractBookFound.showBook();
                    }
                }
                break;
            case 5:
                System.out.println("Enter member id");
                Long memberId = scanner.nextLong();
                library.getMemberRecordsMap().get(memberId).showMembersBooks();
                break;
            case 6:
                Set<Long> keys1 = library.getBooksMap().keySet();
                for(Long key1:keys1){
                    if(library.getBooksMap().get(key1).getStatus().equals(Status.AVAILABLE)){
                        library.getBooksMap().get(key1).showBook();
                    }
                }
                break;
            case 7:
                Set<Long> keys2 = library.getBooksMap().keySet();
                for(Long key2:keys2){
                    if(library.getBooksMap().get(key2).getStatus().equals(Status.LENT)){
                        library.getBooksMap().get(key2).showBook();
                    }
                }
                break;
            case 8:
                Set<Long> keys3 = library.getBooksMap().keySet();
                for(Long key3:keys3){
                    if(library.getBooksMap().get(key3).getStatus().equals(Status.SOLD)){
                        library.getBooksMap().get(key3).showBook();
                    }
                }
                break;
            case 10:
                break;
        }
    }



}
