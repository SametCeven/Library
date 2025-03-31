package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.AbstractBook;
import com.library.models.books.Status;
import com.library.models.core.Library;
import com.library.models.members.AbstractMemberRecord;
import com.library.models.people.Librarian;
import com.library.models.people.AbstractPerson;
import java.util.Scanner;

public class MemberBookActionsMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceMemberBookActionsMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static AbstractBook selectedAbstractBook = SelectBookMenu.getSelectedBook();
    private static AbstractPerson librarianUser = LoginMenu.getLibrarianUser();
    private static AbstractMemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showMemberBookActionsMenu(){
        System.out.println("\n--- Logged in as Member ---");
        System.out.println("--- Menu ---");
        System.out.println("1.Borrow Book");
        System.out.println("2.Return Borrowed Book");
        System.out.println("3.Buy Book");
        System.out.println("4.Return Bought Book");
        System.out.println("10. Exit");

        if (scanner.hasNextInt()){
            choiceMemberBookActionsMenu = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (choiceMemberBookActionsMenu){
            case 1:
                if(selectedAbstractBook.getStatus().equals(Status.AVAILABLE) && memberUser.getNoBooksIssued()<memberUser.getMaxBookLimit()){
                    memberUser.addBookToMember(selectedAbstractBook);
                    selectedAbstractBook.setStatus(Status.LENT);
                }else{
                    System.out.println("Book not available or member would have more than 5 books");
                }
                break;
            case 2:
                if(selectedAbstractBook.getStatus().equals(Status.LENT)){
                    memberUser.removeBookFromMember(selectedAbstractBook);
                    selectedAbstractBook.setStatus(Status.AVAILABLE);
                }else{
                    System.out.println("Book was not lent");
                }
                break;
            case 3:
                if(selectedAbstractBook.getStatus().equals(Status.AVAILABLE)){
                    memberUser.addBookToMember(selectedAbstractBook);
                    selectedAbstractBook.setStatus(Status.SOLD);
                    librarian.createBill(selectedAbstractBook);
                }else{
                    System.out.println("Book not available");
                }
                break;
            case 4:
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
