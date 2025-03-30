package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.*;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;
import com.library.models.people.Librarian;
import com.library.models.people.Person;

import java.text.ParseException;
import java.util.Scanner;

public class LibrarianBookActionsMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceLibrarianBookActionsMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static Book selectedBook = SelectBookMenu.getSelectedBook();
    private static Person librarianUser = LoginMenu.getLibrarianUser();
    private static MemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showLibrarianBookActionsMenu() throws ParseException {
        System.out.println("--- Logged in as Librarian ---");
        System.out.println("--- Menu ---");
        System.out.println("1.Update Book Information");
        System.out.println("2.Delete Book");
        System.out.println("3.Lend Book");
        System.out.println("4.Take Back Lent Book");
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
                System.out.println("What is the member's id");
                Long memberId1 = scanner.nextLong();
                MemberRecord memberFound1 = library.getMemberRecordsMap().get(memberId1);
                if(selectedBook.getStatus().equals(Status.AVAILABLE) && memberFound1.getNoBooksIssued()<5){
                    memberFound1.addBookToMember(selectedBook);
                    memberFound1.incBookIssued();
                    selectedBook.setStatus(Status.LENT);
                }else{
                    System.out.println("Book not available");
                }
                break;
            case 4:
                System.out.println("What is the member's id");
                Long memberId2 = scanner.nextLong();
                MemberRecord memberFound2 = library.getMemberRecordsMap().get(memberId2);
                if(selectedBook.getStatus().equals(Status.LENT)){
                    memberFound2.removeBookFromMember(selectedBook);
                    memberFound2.decBookIssued();
                    selectedBook.setStatus(Status.AVAILABLE);
                }else{
                    System.out.println("Book was not lent");
                }
                break;
            case 5:
                System.out.println("What is the member's id");
                Long memberId3 = scanner.nextLong();
                MemberRecord memberFound3 = library.getMemberRecordsMap().get(memberId3);
                if(selectedBook.getStatus().equals(Status.AVAILABLE)){
                    memberFound3.addBookToMember(selectedBook);
                    selectedBook.setStatus(Status.SOLD);
                    librarian.createBill(selectedBook);
                }else{
                    System.out.println("Book not available");
                }
                break;

        }

    }
}
