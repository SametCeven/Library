package com.library.repository;
import com.library.models.people.Author;
import java.util.*;

public class AuthorRepository {
    private Set<Author> authorSet;

    public AuthorRepository(){
        authorSet = new HashSet<>();

        Author author1 = new Author("author1");
        Author author2 = new Author("author2");
        Author author3 = new Author("author3");

        authorSet.add(author1);
        authorSet.add(author2);
        authorSet.add(author3);

    }

    

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public Author getAuthor(String authorName){
        return
    }
}
