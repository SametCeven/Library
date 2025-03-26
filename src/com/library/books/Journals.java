package com.library.books;

import java.util.Date;

public class Journals extends Book{
    public Journals(Long bookId, String author, String name, Double price, Status status, String edition, Date dateOfPurchase) {
        super(bookId, author, name, price, status, edition, dateOfPurchase);
    }

    public Journals(Long bookId, String author, String name, Double price, Status status, String edition) {
        super(bookId, author, name, price, status, edition);
        setDateOfPurchase(new Date());
    }



}
