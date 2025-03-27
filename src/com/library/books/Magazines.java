package com.library.books;
import com.library.people.Author;
import com.library.people.Person;

import java.util.Date;


public class Magazines extends Book{
    public Magazines(Long bookId, Person author, String name, Double price, Status status, String edition, Date dateOfPurchase) {
        super(bookId, author, name, price, status, edition, dateOfPurchase);
    }

    public Magazines(Long bookId, Person author, String name, Double price, Status status, String edition) {
        super(bookId, author, name, price, status, edition);
    }
}
