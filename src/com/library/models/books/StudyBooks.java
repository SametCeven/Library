package com.library.models.books;
import com.library.models.people.AbstractPerson;
import java.util.Date;


public class StudyBooks extends AbstractBook {
    public StudyBooks(Long bookId, AbstractPerson author, String name, Double price, Status status, String edition, Date dateOfPurchase) {
        super(bookId, author, name, price, status, edition, dateOfPurchase);
    }

    public StudyBooks(Long bookId, AbstractPerson author, String name, Double price, Status status, String edition) {
        super(bookId, author, name, price, status, edition);
    }
}
