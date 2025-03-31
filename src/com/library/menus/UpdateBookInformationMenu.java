package com.library.menus;
import com.library.main.InitialData;
import com.library.models.books.AbstractBook;
import com.library.models.books.Status;
import com.library.models.core.Library;
import com.library.models.members.AbstractMemberRecord;
import com.library.models.people.Librarian;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UpdateBookInformationMenu {
    private static Scanner scanner = LoginMenu.getScanner();
    private static Library library = InitialData.getLibrary();
    private static int choiceUpdateBookInformationMenu;
    private static Librarian librarian = library.getLibrarianMap().get(1L);
    private static AbstractBook selectedAbstractBook = SelectBookMenu.getSelectedBook();

    public static void showUpdateBookInformationMenu() throws ParseException {
        System.out.println("\n--- Logged in as Librarian ---");
        System.out.println("\n--- Menu ---");
        System.out.println("1.Update Book Id");
        System.out.println("2.Update Book Name");
        System.out.println("3.Update Book Price");
        System.out.println("4.Update Book Status");
        System.out.println("5.Update Book Edition");
        System.out.println("6.Update Book Date Of Purchase");
        System.out.println("7.Update Book Owner");
        System.out.println("10. Exit");

        if (scanner.hasNextInt()){
            choiceUpdateBookInformationMenu = scanner.nextInt();
        }else{
            System.out.println("Invalid input, please enter a number between 1 and 10");
            scanner.next();
        }

        switch (choiceUpdateBookInformationMenu){
            case 1:
                System.out.println("Please enter new book id");
                scanner.nextLine();
                Long id = scanner.nextLong();
                selectedAbstractBook.setBookId(id);
                break;
            case 2:
                System.out.println("Please enter new book name");
                scanner.nextLine();
                String name = scanner.nextLine();
                selectedAbstractBook.setName(name);
                break;
            case 3:
                System.out.println("Please enter new book price");
                scanner.nextLine();
                Double price = scanner.nextDouble();
                selectedAbstractBook.setPrice(price);
                break;
            case 4:
                System.out.println("Please enter new book status");
                String statusString = scanner.nextLine();
                if(statusString.equals("SOLD")) selectedAbstractBook.setStatus(Status.SOLD);
                else if(statusString.equals("LENT")) selectedAbstractBook.setStatus(Status.LENT);
                else if(statusString.equals("AVAILABLE")) selectedAbstractBook.setStatus(Status.AVAILABLE);
                break;
            case 5:
                System.out.println("Please enter new book edition");
                String edition = scanner.nextLine();
                selectedAbstractBook.setEdition(edition);
                break;
            case 6:
                System.out.println("Please enter new book purchase of date in the following format DD/MM/YY");
                String dateString = scanner.nextLine();
                SimpleDateFormat dateSimpleDateFormat = new SimpleDateFormat("dd/MM/yy");
                Date date = dateSimpleDateFormat.parse(dateString);
                selectedAbstractBook.setDateOfPurchase(date);
                break;
            case 7:
                System.out.println("Please enter new book owner's member id");
                scanner.nextLine();
                Long newOwnerId = scanner.nextLong();
                AbstractMemberRecord newOwner = library.getMemberRecordsMap().get(newOwnerId);
                AbstractMemberRecord oldOwner = library.findMemberByBook(selectedAbstractBook);
                selectedAbstractBook.changeOwner(newOwner,oldOwner);
                break;
            case 10:
                break;
        }


    }



}
