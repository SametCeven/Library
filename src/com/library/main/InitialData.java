package com.library.main;
import com.library.models.books.*;
import com.library.models.core.Library;
import com.library.models.members.Faculty;
import com.library.models.members.MemberRecord;
import com.library.models.members.Student;
import com.library.models.people.Author;
import com.library.models.people.Librarian;
import com.library.models.people.Person;
import com.library.models.people.Reader;
import java.util.Date;

public class InitialData {
    private static Library library;

    public static void createLibraryWithInitialData(){
        library = new Library();

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


    }

    public static Library getLibrary() {
        return library;
    }
}
