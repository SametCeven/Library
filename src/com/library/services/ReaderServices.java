package com.library.services;
import com.library.models.books.Book;
import com.library.models.books.Status;
import com.library.models.people.Reader;
import java.util.Map;

public class ReaderServices {
    private Reader reader;

    public Map<Long, Book> showReadersBooksMap() {
        return Map.copyOf(this.reader.getReadersBooksMap());
    }

    public void purchaseBook(Book book) throws Exception {
        if(this.reader.getReadersBooksMap().size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            reader.getReadersBooksMap().put(book.getBookId(),book);
            book.setStatus(Status.SOLD);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot purchase more.");
        }
    }

    public void borrowBook(Book book) throws Exception{
        if(reader.getReadersBooksMap().size()<=5 && book.getStatus().equals(Status.AVAILABLE)){
            reader.getReadersBooksMap().put(book.getBookId(),book);
            book.setStatus(Status.LENT);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot borrow more.");
        }
    }

    public void returnBook(Book book) throws Exception{
        if(reader.getReadersBooksMap().containsKey(book.getBookId())){
            reader.getReadersBooksMap().remove(book.getBookId());
            book.setStatus(Status.AVAILABLE);
        }else{
            throw new Exception("Reader does not have the book to be returned.");
        }
    }
}
