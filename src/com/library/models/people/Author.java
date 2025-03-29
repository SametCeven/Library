package com.library.models.people;
import com.library.models.books.Book;
import java.util.*;


public class Author extends Person{
    private Map<Long,Book> authorsBooksMap;


    public Author(String name) {
        super(name);
        this.authorsBooksMap = new HashMap<>();
    }


    @Override
    public String toString(){
        return "Author Name: " + this.getName();
    }
    @Override
    public boolean equals(Object o) {
        if( this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Author author = (Author) o;
        return this.authorsBooksMap.equals(author.authorsBooksMap);
    }
    @Override
    public int hashCode() {
        return Objects.hash(authorsBooksMap);
    }


    @Override
    public String whoYouAre() {
        return "Author: " + super.getName() + "Books: " + authorsBooksMap;
    }
    public void addBook(Book book){
        authorsBooksMap.put(book.getBookId(),book);
    }
    public void removeBook(Book book){
        authorsBooksMap.remove(book.getBookId());
    }
    public Map<Long,Book> showBooks(){
        return authorsBooksMap;
    }



}
