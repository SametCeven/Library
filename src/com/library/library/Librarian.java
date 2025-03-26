package com.library.library;
import com.library.books.Book;
import com.library.members.MemberRecord;
import com.library.people.Author;
import com.library.people.Reader;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Librarian {
    private String name;
    private String password;
    private Library library;
    private Map<Long, MemberRecord> memberRecord;
    private Reader reader;

    public Librarian(String name, String password){
        setName(name);
        setPassword(password);
        memberRecord = new HashMap<>();
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    public Book searchBook(Long bookId){
        return library.getBooksMap().get(bookId);
    }
    public Book searchBook(String bookName){
        Set<Long> booksMapKeys = library.getBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(library.getBooksMap().get(bookMapKey).getName().equals(bookName)){
                return library.getBooksMap().get(bookMapKey);
            }
        }
        return null;
    }
    public Book searchBook(Author authorName){
        Set<Long> booksMapKeys = library.getBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(library.getBooksMap().get(bookMapKey).getAuthor().equals(authorName)){
                return library.getBooksMap().get(bookMapKey);
            }
        }
        return null;
    }
    public boolean verifyMember(Long memberId){
        if (memberRecord.containsKey(memberId)) return true;
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
