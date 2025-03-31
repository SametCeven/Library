package com.library.models.people;
import com.library.models.books.AbstractBook;
import java.util.*;


public class Author extends AbstractPerson {
    private Map<Long, AbstractBook> authorsBooksMap;


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
        return "Author: " + super.getName() + "Books: " + this.authorsBooksMap;
    }

    public void addBook(AbstractBook abstractBook){
        authorsBooksMap.put(abstractBook.getBookId(), abstractBook);
    }

    public void removeBook(AbstractBook abstractBook){
        authorsBooksMap.remove(abstractBook.getBookId());
    }

    public Map<Long, AbstractBook> showBooks(){
        return authorsBooksMap;
    }



}
