package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.*;
import com.library.models.core.Library;
import com.library.models.members.AbstractMemberRecord;
import com.library.models.people.Librarian;
import com.library.models.people.AbstractPerson;
import java.text.ParseException;
import java.util.Scanner;

public class LibrarianBookActionsMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceLibrarianBookActionsMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static AbstractBook selectedAbstractBook = SelectBookMenu.getSelectedBook();
    private static AbstractPerson librarianUser = LoginMenu.getLibrarianUser();
    private static AbstractMemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showLibrarianBookActionsMenu() throws ParseException {
        System.out.println("\n--- Logged in as Librarian ---");
        System.out.println("--- Menu ---");
        System.out.println("1.Update Book Information");
        System.out.println("2.Delete Book");
        System.out.println("3.Lend Book");
        System.out.println("4.Take Back Lent Book");
        System.out.println("5.Sell Book");
        System.out.println("6.Refund Book");
        System.out.println("10. Exit");

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
                library.getBooksMap().remove(selectedAbstractBook.getBookId());
                break;
            case 3:
                System.out.println("What is the member's id");
                Long memberId1 = scanner.nextLong();
                AbstractMemberRecord memberFound1 = library.getMemberRecordsMap().get(memberId1);
                if(selectedAbstractBook.getStatus().equals(Status.AVAILABLE) && memberFound1.getNoBooksIssued()<memberUser.getMaxBookLimit()){
                    memberFound1.addBookToMember(selectedAbstractBook);
                    selectedAbstractBook.setStatus(Status.LENT);
                }else{
                    System.out.println("Book not available or member would have more than 5 books");
                }
                break;
            case 4:
                System.out.println("What is the member's id");
                Long memberId2 = scanner.nextLong();
                AbstractMemberRecord memberFound2 = library.getMemberRecordsMap().get(memberId2);
                if(selectedAbstractBook.getStatus().equals(Status.LENT)){
                    memberFound2.removeBookFromMember(selectedAbstractBook);
                    selectedAbstractBook.setStatus(Status.AVAILABLE);
                }else{
                    System.out.println("Book was not lent");
                }
                break;
            case 5:
                System.out.println("What is the member's id");
                Long memberId3 = scanner.nextLong();
                AbstractMemberRecord memberFound3 = library.getMemberRecordsMap().get(memberId3);
                if(selectedAbstractBook.getStatus().equals(Status.AVAILABLE)){
                    memberFound3.addBookToMember(selectedAbstractBook);
                    selectedAbstractBook.setStatus(Status.SOLD);
                    librarian.createBill(selectedAbstractBook);
                }else{
                    System.out.println("Book not available");
                }
                break;
            case 6:
                if(selectedAbstractBook.getStatus().equals(Status.SOLD)){
                    memberUser.removeBookFromMember(selectedAbstractBook);
                    selectedAbstractBook.setStatus(Status.AVAILABLE);
                }else{
                    System.out.println("Book was not bought");
                }
                break;
            case 10:
                break;

        }

    }
}
