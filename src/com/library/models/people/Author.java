package com.library.models.people;
import com.library.models.books.Book;
import java.util.*;


public class Author extends Person implements Comparable<Author>{
    private Map<Long,Book> authorsBooksMap;

    public Author(String name) {
        super(name);
        this.authorsBooksMap = new HashMap<>();
    }

    public Map<Long, Book> getAuthorsBooksMap() {
        return authorsBooksMap;
    }

    @Override
    public String whoYouAre() {
        return "Author: " + super.getName() + "Books: " + authorsBooksMap;
    }

    @Override
    public String toString(){
        return "Author Name: " + super.getName();
    }

    @Override
    public boolean equals(Object o) {
        if( this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return this.getName().equals(author.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName());
    }

    @Override
    public int compareTo(Author o) {
        return super.getName().compareTo(o.getName());
    }
}
