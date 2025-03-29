package com.library.services;
import com.library.models.books.Book;
import com.library.models.people.Author;
import com.library.repository.AuthorRepository;

import java.util.Map;

public class AuthorServices {
    AuthorRepository authorRepository;



    public void addBook(Book book){
        authorRepository.getAuthorsBooksMap().put(book.getBookId(),book);
    }

    public void removeBook(Book book){
        author.getAuthorsBooksMap().remove(book.getBookId());
    }

    public Map<Long,Book> showBooks(){
        return Map.copyOf(author.getAuthorsBooksMap());
    }


}
