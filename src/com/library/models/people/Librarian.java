package com.library.models.people;
import com.library.models.books.AbstractBook;
import com.library.models.core.Library;
import com.library.models.members.AbstractMemberRecord;

import java.util.*;


public class Librarian extends AbstractPerson {
    private Long id;
    private String password;
    private Library library;
    private Map<Long, AbstractMemberRecord> memberRecordMap;

    public Librarian(Long id,String name, String password,Library library){
        super(name);
        this.setId(id);
        this.setPassword(password);
        this.library = library;
        library.addLibrarian(this);
    }
    public Librarian(String name,String password){
        super(name);
        this.setPassword(password);
    }

    public Long getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Librarian" + "\n" +
                "Name: " + super.getName() + "\n" +
                "Password: " + password;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return this.getId().equals(librarian.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }



    public AbstractBook searchBook(Long bookId){
        return this.library.getBooksMap().get(bookId);
    }

    public AbstractBook searchBook(String bookName) {
        Set<Long> booksMapKeys = this.library.getBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(this.library.getBooksMap().get(bookMapKey).getName().equals(bookName)){
                return this.library.getBooksMap().get(bookMapKey);
            }
        }
        return null;
    }

    public List<AbstractBook> searchBook(Author authorName){
        List<AbstractBook> foundAbstractBooks = new ArrayList<>();
        Set<Long> booksMapKeys = this.library.getBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(this.library.getBooksMap().get(bookMapKey).getAuthor().getName().equals(authorName.getName())){
                foundAbstractBooks.add(this.library.getBooksMap().get(bookMapKey));
            }
        }
        return foundAbstractBooks;
    }


    public void createBill(AbstractBook abstractBook){
        System.out.println(
                "Bill: " + "\n" +
                "Price: " + abstractBook.getPrice() + "\n" +
                "Date of purchase: " + new Date()
        );
    }








}
