package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.Book;
import com.library.models.core.Library;
import com.library.models.people.Librarian;
import java.util.Scanner;

public class MemberBookActionsMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceMemberBookActionsMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static Book selectedBook = SelectBookMenu.getSelectedBook();

    public static void showMemberBookActionsMenu(){
        System.out.println("--- Menu ---");
        System.out.println("1.Borrow Book");
        System.out.println("2.Return Borrowed Book");
        System.out.println("3.Buy Book");


    }
}
