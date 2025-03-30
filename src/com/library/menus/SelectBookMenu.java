package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.Book;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;
import com.library.models.people.Librarian;
import com.library.models.people.Person;
import java.text.ParseException;
import java.util.Scanner;

public class SelectBookMenu {

    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceSelectBookMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static Book selectedBook;
    private static Person librarianUser = LoginMenu.getLibrarianUser();
    private static MemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showSelectBookMenu() throws ParseException {
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
                System.out.println("Please enter book id");
                scanner.nextLine();
                Long id = scanner.nextLong();
                selectedBook = librarian.searchBook(id);
                if (librarianUser != null) LibrarianBookActionsMenu.showLibrarianBookActionsMenu();
                else if (memberUser != null) MemberBookActionsMenu.showMemberBookActionsMenu();
                break;
            case 2:
                System.out.println("Please enter book name");
                scanner.nextLine();
                String name = scanner.nextLine();
                selectedBook = librarian.searchBook(name);
                if (librarianUser != null) LibrarianBookActionsMenu.showLibrarianBookActionsMenu();
                else if (memberUser != null) MemberBookActionsMenu.showMemberBookActionsMenu();
                break;
            case 3:
                System.out.println("Please enter author name");
                String author = scanner.nextLine();
                selectedBook = librarian.searchBook(author);
                if (librarianUser != null) LibrarianBookActionsMenu.showLibrarianBookActionsMenu();
                else if (memberUser != null) MemberBookActionsMenu.showMemberBookActionsMenu();
                break;
        }

    }

    public static Book getSelectedBook() {
        return selectedBook;
    }

}
