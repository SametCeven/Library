package com.library.main;

import com.library.models.books.*;
import com.library.models.members.Faculty;
import com.library.models.members.MemberRecord;
import com.library.models.members.Student;
import com.library.models.people.*;
import com.library.models.core.Library;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // ********* Initial Data for the library **********
        Library library = new Library();

        Person librarian = new Librarian(1L,"name","password",library);
        library.addLibrarian(librarian);

        Person reader1 = new Reader("Student1");
        Person reader2 = new Reader("Student2");
        Person reader3 = new Reader("Faculty1");
        Person reader4 = new Reader("Faculty2");
        MemberRecord memberRecord1 = new Student(1L,reader1.getName(),new Date(),0,"Address1","+90212");
        MemberRecord memberRecord2 = new Student(2L,reader2.getName(),new Date(),0,"Address2","+90212");
        MemberRecord memberRecord3 = new Faculty(3L,reader3.getName(),new Date(),0,"Address3","+90212");
        MemberRecord memberRecord4 = new Faculty(4L,reader4.getName(),new Date(),0,"Address4","+90212");
        library.addReaderRecord(memberRecord1);
        library.addReaderRecord(memberRecord2);
        library.addReaderRecord(memberRecord3);
        library.addReaderRecord(memberRecord4);

        Person author1 = new Author("author1");
        Person author2 = new Author("author2");
        Person author3 = new Author("author3");
        Book[] booksArray = {
        new Journals(1L, author1, "Nature Journal", 120.00, Status.AVAILABLE, "Vol. 50"),
        new Journals(2L, author1, "Science Advances", 95.00, Status.AVAILABLE, "Vol. 15"),
        new Journals(3L, author1, "The Lancet", 150.00, Status.AVAILABLE, "Vol. 78"),
        new Journals(4L, author1, "Harvard Business Review", 110.00, Status.LENT, "March 2024"),
        new Journals(5L, author1, "IEEE Transactions", 130.00, Status.SOLD, "2024 Issue"),
        new StudyBooks(6L, author1, "Introduction to Algorithms", 80.00, Status.AVAILABLE, "3rd Edition"),
        new Magazines(7L, author1, "Time Magazine", 50.00, Status.AVAILABLE, "April 2024 Issue"),
        new Journals(8L, author2, "Journal of AI Research", 140.00, Status.AVAILABLE, "Vol. 25"),
        new Journals(9L, author2, "Psychology Today", 90.00, Status.AVAILABLE, "Jan 2024 Issue"),
        new Journals(10L, author2, "National Geographic Research", 125.00, Status.AVAILABLE, "Spring 2024"),
        new Journals(11L, author2, "Medical Journal", 135.00, Status.LENT, "Vol. 30"),
        new Journals(12L, author2, "The Economist", 100.00, Status.SOLD, "Feb 2024 Issue"),
        new StudyBooks(13L, author2, "Physics for Scientists and Engineers", 85.00, Status.AVAILABLE, "10th Edition"),
        new Magazines(14L, author2, "Forbes", 55.00, Status.AVAILABLE, "Business Special"),
        new Journals(15L, author3, "Computer Science Review", 145.00, Status.AVAILABLE, "Vol. 8"),
        new Journals(16L, author3, "MIT Technology Review", 105.00, Status.AVAILABLE, "Summer 2024"),
        new Journals(17L, author3, "Stanford Law Review", 95.00, Status.AVAILABLE, "Vol. 72"),
        new Journals(18L, author3, "Oxford Economic Papers", 115.00, Status.LENT, "2024 Edition"),
        new Journals(19L, author3, "Harvard Law Review", 120.00, Status.SOLD, "Vol. 137"),
        new StudyBooks(20L, author3, "Advanced Engineering Mathematics", 90.00, Status.AVAILABLE, "5th Edition"),
        new Magazines(21L, author3, "Scientific American", 65.00, Status.AVAILABLE, "May 2024 Issue")
        };
        for(Book book:booksArray){
            library.addBook(book);
        }



        // ********** THE CONSOLE APPLICATION ***********

        Map<Long,Book> bookMap = library.getBooksMap();
        Set<Long> bookMapKeys = bookMap.keySet();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int librarianChoice = 0;
        int memberChoice = 0;
        int showBooksChoice = 0;

        while(choice != 10){

            System.out.println("\n --- Menu ---");
            System.out.println("1. Login as a Librarian");
            System.out.println("2. Login as a Member");
            System.out.println("10. Exit");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
            }else{
                System.out.println("Invalid input, please enter a number between 1 and 10");
                scanner.next();
            }

            // *** LIBRARIAN MENU
            switch (choice){
                case 1:
                    System.out.println("Please enter name");
                    scanner.nextLine();
                    String nameLibrarian = scanner.nextLine();
                    System.out.println("Plase enter password");
                    String passwordLibrarian = scanner.nextLine();
                    if(!library.hasLibrarian(new Librarian(nameLibrarian,passwordLibrarian))){
                        System.out.println("Cannot find librarian try again");
                    }else{
                        System.out.println("\n--- Logged in as Librarian ---");
                        System.out.println("--- Menu ---");
                        System.out.println("1. Show books"); // id,isim,author
                        System.out.println("2. Select book"); // update,delete
                        System.out.println("3. Add book");
                        System.out.println("10. Exit");
                        if (scanner.hasNextInt()){
                            librarianChoice = scanner.nextInt();
                        }else{
                            System.out.println("Invalid input, please enter a number between 1 and 10");
                            scanner.next();
                        }
                        // *** LIBRARIAN - 1. SHOW BOOKS MENU
                        switch (librarianChoice){
                            case 1:
                                System.out.println("\n--- Logged in as Librarian ---");
                                System.out.println("--- Menu ---");
                                System.out.println("1.Show All Books");
                                System.out.println("2.Show Books by ID");
                                System.out.println("3.Show Books by Name");
                                System.out.println("4.Show Books by Author");
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
                                        Book bookFound2 = ((Librarian)librarian).searchBook(bookId);
                                        if(bookFound2 == null) System.out.println("Book not found");
                                        else bookFound2.showBook();
                                        break;
                                    case 3:
                                        System.out.println("Enter book name");
                                        scanner.nextLine();
                                        String bookName = scanner.nextLine();
                                        Book bookFound3 = ((Librarian)librarian).searchBook(bookName);
                                        if(bookFound3 == null) System.out.println("Book not found");
                                        else bookFound3.showBook();
                                        break;
                                    case 4:
                                        System.out.println("Enter author name");
                                        scanner.nextLine();
                                        String bookAuthor = scanner.nextLine();
                                        List<Book> bookFound4 = ((Librarian)librarian).searchBook(new Author(bookAuthor));
                                        System.out.println(bookFound4);
                                        if(bookFound4 == null) System.out.println("Book not found");
                                        else{
                                            for(Book bookFound:bookFound4){
                                                bookFound.showBook();
                                            }
                                        }
                                        break;
                                }
                                break;

                            // *** LIBRARIAN - 2. SELECT BOOK MENU
                            case 2:
                        }
                    }
                    break;

                // *** MEMBER MENU
                case 2:
                    System.out.println("Please enter your id");
                    scanner.nextLine();
                    Long idMember = scanner.nextLong();
                    if(!library.hasMember(idMember)){
                        System.out.println("Cannot find member try again");
                    }else{
                        System.out.println("\n--- Logged in as Member ---");
                        System.out.println("--- Menu ---");
                        System.out.println("1. Show books"); // id,isim,author
                        System.out.println("2. Select book"); // update,delete,borrow,return
                        System.out.println("10. Exit");
                        if (scanner.hasNextInt()){
                            memberChoice = scanner.nextInt();
                        }else{
                            System.out.println("Invalid input, please enter a number between 1 and 10");
                            scanner.next();
                        }
                        // *** MEMBER - 1. SHOW BOOKS MENU
                        switch (memberChoice){
                            case 1:
                                System.out.println("\n--- Logged in as Member ---");
                                System.out.println("--- Menu ---");
                                System.out.println("1.Show All Books");
                                System.out.println("2.Show Books by ID");
                                System.out.println("3.Show Books by Name");
                                System.out.println("4.Show Books by Author");
                                if (scanner.hasNextInt()){
                                    showBooksChoice = scanner.nextInt();
                                }else {
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
                                        Book bookFound2 = ((Librarian)librarian).searchBook(bookId);
                                        if(bookFound2 == null) System.out.println("Book not found");
                                        else bookFound2.showBook();
                                        break;
                                    case 3:
                                        System.out.println("Enter book name");
                                        scanner.nextLine();
                                        String bookName = scanner.nextLine();
                                        Book bookFound3 = ((Librarian)librarian).searchBook(bookName);
                                        if(bookFound3 == null) System.out.println("Book not found");
                                        else bookFound3.showBook();
                                        break;
                                    case 4:
                                        System.out.println("Enter author name");
                                        scanner.nextLine();
                                        String bookAuthor = scanner.nextLine();
                                        List<Book> bookFound4 = ((Librarian)librarian).searchBook(new Author(bookAuthor));
                                        System.out.println(bookFound4);
                                        if(bookFound4 == null) System.out.println("Book not found");
                                        else{
                                            for(Book bookFound:bookFound4){
                                                bookFound.showBook();
                                            }
                                        }
                                        break;
                                }
                                break;

                            // *** MEMBER - 2. SELECT BOOKS MENU
                            case 2:

                        }

                    }
                    break;
            }
        }

        scanner.close();



        /*while(choice != 10){
            System.out.println("\n --- Menu ---");
            System.out.println("1. Show books");
            System.out.println("2. Add book");
            System.out.println("10. Exit");

            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
            }else{
                System.out.println("Invalid input, please enter a number between 1 and 10");
                scanner.next();
                continue;
            }

            switch (choice){
                case 1:
                    System.out.println("1.Show All Books");
                    System.out.println("2.Show Books by ID");
                    System.out.println("3.Show Books by Name");
                    System.out.println("4.Show Books by Author");
                    showBooksChoice = scanner.nextInt();
                    switch (showBooksChoice){
                        case 1:
                            System.out.println(bookMap);
                            break;
                        case 2:
                            System.out.println("Enter Book ID");
                            Long bookId = scanner.nextLong();
                            if(bookMap.containsKey(bookId)){
                                System.out.println(bookMap.get(bookId));
                            }else{
                                System.out.println("Book ID not found.");
                            }
                            break;
                        case 3:
                            System.out.println("Enter Book Name");
                            scanner.nextLine();
                            String bookName = scanner.nextLine();
                            int countBookName = 0;
                            for(Long bookMapKey:bookMapKeys){
                                if(bookMap.get(bookMapKey).getName().equals(bookName)){
                                    System.out.println(bookMap.get(bookMapKey));
                                }else{
                                    countBookName++;
                                }
                            }
                            if(countBookName==bookMapKeys.size()) System.out.println("Book not found");
                            break;
                        case 4:
                            System.out.println("Enter Author Name");
                            scanner.nextLine();
                            String authorName = scanner.nextLine();
                            int countAuthorName = 0;
                            for(Long bookMapKey:bookMapKeys){
                                if(bookMap.get(bookMapKey).getAuthor().getName().equals(authorName)){
                                    System.out.println(bookMap.get(bookMapKey));
                                }else{
                                    countAuthorName++;
                                }
                            }
                            if(countAuthorName==bookMapKeys.size()) System.out.println("Author not found");
                            break;
                    }




                    break;
                case 2:
                    System.out.println("Enter book id");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Enter author name");
                    String authorName = scanner.nextLine();
                    System.out.println("Enter book name");
                    String bookName = scanner.nextLine();
                    System.out.println("Enter price");
                    Double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter edition");
                    String edition = scanner.nextLine();
                    System.out.println("Enter book type (Journals,Magazines,StudyBooks)");
                    String bookType = scanner.nextLine();
                    switch (bookType){
                        case "Journals":
                            Book bookNewJournals = new Journals(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition,new Date());
                            bookMap.put(bookNewJournals.getBookId(),bookNewJournals);
                        case "Magazines":
                            Book bookNewMagazines = new Magazines(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition,new Date());
                            bookMap.put(bookNewMagazines.getBookId(),bookNewMagazines);
                        case "StudyBooks":
                            Book bookNewStudyBooks = new StudyBooks(bookId,new Author(authorName),bookName,price,Status.AVAILABLE,edition,new Date());
                            bookMap.put(bookNewStudyBooks.getBookId(),bookNewStudyBooks);
                    }
                    break;
                case 10:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("default");

            }
        }
        scanner.close();*/

    }
}