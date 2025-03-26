package com.library.people;
import com.library.books.Book;
import com.library.books.Status;

import java.util.HashMap;
import java.util.Map;

public class Reader extends Person{
    private Map<Long,Book> books;


    public Reader(String name) {
        super(name);
        books = new HashMap<>();
    }


    @Override
    public String whoYouAre() {
        return "Reader: " + super.getName() + " Books: " + books;
    }


    public void purchaseBook(Book book) throws Exception {
        if(books.size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            books.put(book.getBookId(),book);
            book.setStatus(Status.SOLD);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot purchase more.");
        }
    }

    public void borrowBook(Book book) throws Exception{
        if(books.size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            books.put(book.getBookId(),book);
            book.setStatus(Status.LENT);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot borrow more.");
        }
    }

    public void returnBook(Book book) throws Exception{
        if(books.containsKey(book.getBookId())){
            books.remove(book.getBookId());
            book.setStatus(Status.AVAILABLE);
        }else{
            throw new Exception("Reader does not have the book to be returned.");
        }
    }

    public Map<Long,Book> showBook(){
        return books;
    }


}
