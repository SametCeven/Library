package com.library.people;
import com.library.books.Book;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person{
    private Set<Book> books;


    public Author(String name) {
        super(name);
        this.books = new HashSet<>();
    }


    @Override
    public String whoYouAre() {
        return "Author: " + super.getName() + "Books: " + books;

    }


    public void newBook(Book book){
        books.add(book);
    }

    public Set<Book> showBook(){
        return books;
    }


}
