package com.library.people;
import com.library.books.Book;
import com.library.books.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Reader extends Person{
    private Map<Long,Book> booksMap;

    public Reader(String name) {
        super(name);
        booksMap = new HashMap<>();
    }


    @Override
    public String whoYouAre() {
        return "Reader: " + super.getName() + " Books: " + booksMap;
    }
    @Override
    public String toString(){
        return getName();
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return Objects.equals(booksMap, reader.booksMap);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), booksMap);
    }


    public void purchaseBook(Book book) throws Exception {
        if(booksMap.size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            booksMap.put(book.getBookId(),book);
            book.setStatus(Status.SOLD);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot purchase more.");
        }
    }
    public void borrowBook(Book book) throws Exception{
        if(booksMap.size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            booksMap.put(book.getBookId(),book);
            book.setStatus(Status.LENT);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot borrow more.");
        }
    }
    public void returnBook(Book book) throws Exception{
        if(booksMap.containsKey(book.getBookId())){
            booksMap.remove(book.getBookId());
            book.setStatus(Status.AVAILABLE);
        }else{
            throw new Exception("Reader does not have the book to be returned.");
        }
    }
    public Map<Long,Book> showBook(){
        return booksMap;
    }


}
