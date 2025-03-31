package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.AbstractBook;
import com.library.models.core.Library;
import com.library.models.members.AbstractMemberRecord;
import com.library.models.people.Author;
import com.library.models.people.Librarian;
import com.library.models.people.AbstractPerson;
import java.text.ParseException;
import java.util.Scanner;

public class SelectBookMenu {

    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceSelectBookMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static AbstractBook selectedAbstractBook;
    private static AbstractPerson librarianUser = LoginMenu.getLibrarianUser();
    private static AbstractMemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showSelectBookMenu() throws ParseException {
        librarianUser = LoginMenu.getLibrarianUser();
        memberUser = LoginMenu.getMemberUser();
        if (librarianUser != null) System.out.println("\n--- Logged in as Librarian ---");
        else if (memberUser != null) System.out.println("\n--- Logged in as Member ---");
        System.out.println("--- Menu ---");
        System.out.println("1.Select Book by ID");
        System.out.println("2.Select Book by Name");
        System.out.println("3.Select Book by Author");
        System.out.println("10. Exit");

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
                selectedAbstractBook = librarian.searchBook(id);
                if (librarianUser != null) LibrarianBookActionsMenu.showLibrarianBookActionsMenu();
                else if (memberUser != null) MemberBookActionsMenu.showMemberBookActionsMenu();
                break;
            case 2:
                System.out.println("Please enter book name");
                scanner.nextLine();
                String name = scanner.nextLine();
                selectedAbstractBook = librarian.searchBook(name);
                if (librarianUser != null) LibrarianBookActionsMenu.showLibrarianBookActionsMenu();
                else if (memberUser != null) MemberBookActionsMenu.showMemberBookActionsMenu();
                break;
            case 3:
                System.out.println("Please enter author name");
                scanner.nextLine();
                String author = scanner.nextLine();
                selectedAbstractBook = librarian.searchBook(new Author(author)).get(0);
                if (librarianUser != null) LibrarianBookActionsMenu.showLibrarianBookActionsMenu();
                else if (memberUser != null) MemberBookActionsMenu.showMemberBookActionsMenu();
                break;
            case 10:
                break;
        }

    }

    public static AbstractBook getSelectedBook() {
        return selectedAbstractBook;
    }

}
