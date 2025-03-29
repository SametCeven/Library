package com.library.models.core;
import com.library.models.books.Book;
import com.library.models.members.MemberRecord;
import com.library.models.people.*;
import java.util.*;


public class Library {
    private Map<Long, Book> libraryBooksMap;
    private Map<Long,MemberRecord> memberRecordsMap;
    private Map<Long, Librarian> librariansMap;

    public Library(){
        this.libraryBooksMap = new HashMap<>();
        this.memberRecordsMap = new HashMap<>();
        this.librariansMap = new HashMap<>();
    }

    public Map<Long, Book> getBooksMap() {
        return this.libraryBooksMap;
    }
    public Map<Long,MemberRecord> getMemberRecordsMap() {return this.memberRecordsMap;}
    public Map<Long,Librarian> getLibrarianMap() {return this.librariansMap;}

    public void addBook(Book newBook){
        this.libraryBooksMap.put(newBook.getBookId(),newBook);
    }
    public void lendBook(Reader reader, Book book) throws Exception {
        reader.borrowBook(book);
    }
    public void takeBackBook(Reader reader,Book book) throws Exception {
        reader.returnBook(book);
    }
    public void addReaderRecord(MemberRecord memberRecord){
        this.memberRecordsMap.put(memberRecord.getMemberId(),memberRecord);
    }
    public void removeReader(MemberRecord memberRecord){
        this.memberRecordsMap.remove(memberRecord.getMemberId());
    }
    public void addLibrarian(Person librarian){
        Librarian librarian1 = (Librarian) librarian;
        this.librariansMap.put(librarian1.getId(),librarian1);
    }
    public void removeLibrarian(Librarian librarian){
        this.librariansMap.remove(librarian.getId());
    }
    public boolean hasLibrarian(Librarian librarian){
        return this.librariansMap.containsValue(librarian);
    }
    public boolean hasMember(Long memberId){
        return this.memberRecordsMap.containsKey(memberId);
    }
    public void showLibraryBooks(){
        Set<Long> libraryBooksMapKeys = libraryBooksMap.keySet();
        for(Long libraryBooksMapKey:libraryBooksMapKeys){
            libraryBooksMap.get(libraryBooksMapKey).showBook();
        }
    }


    @Override
    public String toString() {
        return "Library{" +
                "booksMap=" + this.libraryBooksMap +
                ", memberRecordsMap=" + this.memberRecordsMap +
                ", librariansMap=" + this.librariansMap +
                '}';
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Library library = (Library) obj;
        return this.librariansMap.equals(library.getLibrarianMap());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.librariansMap);
    }

}
