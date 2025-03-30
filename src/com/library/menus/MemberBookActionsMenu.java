package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.Book;
import com.library.models.books.Status;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;
import com.library.models.people.Librarian;
import com.library.models.people.Person;
import java.util.Scanner;

public class MemberBookActionsMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceMemberBookActionsMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static Book selectedBook = SelectBookMenu.getSelectedBook();
    private static Person librarianUser = LoginMenu.getLibrarianUser();
    private static MemberRecord memberUser = LoginMenu.getMemberUser();

    public static void showMemberBookActionsMenu(){
        System.out.println("--- Logged in as Member ---");
        System.out.println("--- Menu ---");
        System.out.println("1.Borrow Book");
        System.out.println("2.Return Borrowed Book");
        System.out.println("3.Buy Book");

        if (scanner.hasNextInt()){
            choiceMemberBookActionsMenu = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (choiceMemberBookActionsMenu){
            case 1:
                if(selectedBook.getStatus().equals(Status.AVAILABLE) && memberUser.getNoBooksIssued()<5){
                    memberUser.addBookToMember(selectedBook);
                    memberUser.incBookIssued();
                    selectedBook.setStatus(Status.LENT);
                }else{
                    System.out.println("Book not available");
                }
                break;
            case 2:
                if(selectedBook.getStatus().equals(Status.LENT)){
                    memberUser.removeBookFromMember(selectedBook);
                    memberUser.decBookIssued();
                    selectedBook.setStatus(Status.AVAILABLE);
                }else{
                    System.out.println("Book was not lent");
                }
                break;
            case 3:
                if(selectedBook.getStatus().equals(Status.AVAILABLE)){
                    memberUser.addBookToMember(selectedBook);
                    selectedBook.setStatus(Status.SOLD);
                    librarian.createBill(selectedBook);
                }else{
                    System.out.println("Book not available");
                }
                break;


        }

    }
}
