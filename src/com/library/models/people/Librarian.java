package com.library.models.people;
import com.library.models.books.Book;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;

import java.util.*;


public class Librarian extends Person {
    private String password;
    private Library library;
    private Map<Long, MemberRecord> memberRecordMap;

    public Librarian(Long id, String name, String password,Library library){
        super(id,name);
        this.setPassword(password);
        this.library = library;
        library.addLibrarian(this);
    }
    public Librarian(Long id, String name, String password){
        super(id,name);
        this.setPassword(password);
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + super.getName() + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return super.getId().equals(librarian.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId());
    }

    @Override
    public String whoYouAre() {
        return "Name: " + super.getName();
    }

    public Book searchBook(Long bookId){
        return library.getBooksMap().get(bookId);
    }

    public Book searchBook(String bookName) {
        Set<Long> booksMapKeys = library.getBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(library.getBooksMap().get(bookMapKey).getName().equals(bookName)){
                return library.getBooksMap().get(bookMapKey);
            }
        }
        return null;
    }

    public List<Book> searchBook(Author authorName){
        List<Book> foundBooks = new ArrayList<>();
        Set<Long> booksMapKeys = library.getBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(library.getBooksMap().get(bookMapKey).getAuthor().getName().equals(authorName.getName())){
                foundBooks.add(library.getBooksMap().get(bookMapKey));
            }
        }
        return foundBooks;
    }

    public boolean verifyMember(Long memberId){
        if (memberRecordMap.containsKey(memberId)) return true;
        else return false;
    }

    public void issueBook(Book book){
        library.getBooksMap().put(book.getBookId(),book);
    }
    public double calculateFine(){
        return 0.0;
    }
    public void createBill(){

    }
    public void returnBook(Reader reader, Book book) throws Exception {
        library.takeBackBook(reader,book);
    }







}
