package com.library.services;
import com.library.models.books.Book;
import com.library.models.members.MemberRecord;

public class BookServices {
    private Book book;

    public void showBook() {
        System.out.println(
                "Book ID: " + book.getBookId() + "," +
                " Name: " + book.getName() + "," +
                " Author Name: " + book.getAuthor().getName());
    }

    public void changeOwner(Book book, MemberRecord newOwner) throws Exception{

    }

    public void updateStatus(){

    }
}