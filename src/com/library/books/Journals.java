package com.library.books;
import com.library.people.Person;
import java.util.Date;

public class Journals extends Book{
    public Journals(Long bookId, Person author, String name, Double price, Status status, String edition, Date dateOfPurchase) {
        super(bookId, author, name, price, status, edition, dateOfPurchase);
    }

    public Journals(Long bookId, Person author, String name, Double price, Status status, String edition) {
        super(bookId, author, name, price, status, edition);
        setDateOfPurchase(new Date());
    }


}
