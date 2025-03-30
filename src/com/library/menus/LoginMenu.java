package com.library.menus;
import com.library.main.InitialData;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;
import com.library.models.people.Librarian;
import com.library.models.people.Person;

import java.text.ParseException;
import java.util.Scanner;


public class LoginMenu {
    private static Scanner scanner;
    private static int choice;
    private static Library library = InitialData.getLibrary();
    private static Person librarianUser;
    private static MemberRecord memberUser;

    public static void showLoginMenu() throws ParseException {
        scanner = new Scanner(System.in);

        while (choice != 10) {

            System.out.println("\n --- Menu ---");
            System.out.println("1. Login as a Librarian");
            System.out.println("2. Login as a Member");
            System.out.println("10. Exit");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input, please enter a number between 1 and 10");
                scanner.next();
            }

            switch (choice) {
                case 1:
                    System.out.println("Please enter name");
                    scanner.nextLine();
                    String nameLibrarian = scanner.nextLine();
                    System.out.println("Plase enter password");
                    String passwordLibrarian = scanner.nextLine();
                    librarianUser = library.findLibrarianByNameAndPassword(nameLibrarian,passwordLibrarian);

                    if(!library.hasLibrarian((Librarian) librarianUser)){
                        System.out.println("Cannot find librarian try again");
                    }else{
                        librarianUser = library.getLibrarianMap().get(((Librarian)librarianUser).getId());
                        LibrarianMenu.showLibrarianMenu();
                    }

                    break;

                case 2:
                    System.out.println("Please enter your id");
                    scanner.nextLine();
                    Long idMember = scanner.nextLong();

                    if (!library.hasMember(idMember)) {
                        System.out.println("Cannot find member try again");
                    }else {
                        memberUser = library.getMemberRecordsMap().get(idMember);
                        MemberMenu.showReaderMenu();
                    }

                    break;

            }

        }
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static MemberRecord getMemberUser() {
        return memberUser;
    }

    public static Person getLibrarianUser() {
        return librarianUser;
    }
}
