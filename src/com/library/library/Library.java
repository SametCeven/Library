package com.library.library;
import com.library.books.Book;
import com.library.people.Reader;
import java.util.*;

public class Library {
    private Map<Long, Book> booksMap;
    private Set<Reader> readersSet;

    public Library(){
        this.booksMap = new HashMap<>();
        this.readersSet = new HashSet();
    }

    public Map<Long, Book> getBooksMap() {
        return booksMap;
    }
    public Set<Reader> getReadersMap() {
        return readersSet;
    }
    public void setBooksMap(Map<Long, Book> booksMap) {
        this.booksMap = booksMap;
    }
    public void setReadersMap(Set<Reader> readersSet) {
        this.readersSet = readersSet;
    }

    public void addBook(Book newBook){
        booksMap.put(newBook.getBookId(),newBook);
    }
    public void lendBook(Reader reader, Book book) throws Exception {
        reader.borrowBook(book);
    }
    public void takeBackBook(Reader reader,Book book) throws Exception {
        reader.returnBook(book);
    }
    public Map<Long,Book> showBook(){
        return booksMap;
    }





}
