package com.library.people;
import com.library.books.Book;

import java.util.HashSet;
import java.util.Objects;
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
    @Override
    public String toString(){
        return getName();
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return Objects.equals(books, author.books);
    }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), books);
    }


    public void newBook(Book book){
        books.add(book);
    }

    public Set<Book> showBook(){
        return books;
    }


}
