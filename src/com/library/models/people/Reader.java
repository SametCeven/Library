package com.library.models.people;
import com.library.models.books.Book;
import com.library.models.books.Status;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Reader extends Person {
    private Map<Long,Book> readersBooksMap;


    public Reader(Long id, String name) {
        super(id, name);
        this.readersBooksMap = new HashMap<>();
    }


    @Override
    public String toString(){
        return "Reader Name: " + super.getName();
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return super.getId().equals(reader.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.getId());
    }


    @Override
    public String whoYouAre() {
        return "Reader: " + super.getName() + " Books: " + this.readersBooksMap;
    }

    public Map<Long, Book> showReadersBooksMap() {
        return this.readersBooksMap;
    }

    public void purchaseBook(Book book) throws Exception {
        if(this.readersBooksMap.size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            readersBooksMap.put(book.getBookId(),book);
            book.setStatus(Status.SOLD);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot purchase more.");
        }
    }

    public void borrowBook(Book book) throws Exception{
        if(readersBooksMap.size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            readersBooksMap.put(book.getBookId(),book);
            book.setStatus(Status.LENT);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot borrow more.");
        }
    }

    public void returnBook(Book book) throws Exception{
        if(readersBooksMap.containsKey(book.getBookId())){
            readersBooksMap.remove(book.getBookId());
            book.setStatus(Status.AVAILABLE);
        }else{
            throw new Exception("Reader does not have the book to be returned.");
        }
    }


}
