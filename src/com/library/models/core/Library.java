package com.library.models.core;
import com.library.models.books.AbstractBook;
import com.library.models.members.AbstractMemberRecord;
import com.library.models.people.*;
import java.util.*;


public class Library {
    private Map<Long, AbstractBook> libraryBooksMap;
    private Map<Long, AbstractMemberRecord> memberRecordsMap;
    private Map<Long, Librarian> librariansMap;

    public Library(){
        this.libraryBooksMap = new HashMap<>();
        this.memberRecordsMap = new HashMap<>();
        this.librariansMap = new HashMap<>();
    }

    public Map<Long, AbstractBook> getBooksMap() {
        return this.libraryBooksMap;
    }
    public Map<Long, AbstractMemberRecord> getMemberRecordsMap() {
        return this.memberRecordsMap;
    }
    public Map<Long,Librarian> getLibrarianMap() {
        return this.librariansMap;
    }

    public void addBook(AbstractBook newAbstractBook){
        this.libraryBooksMap.put(newAbstractBook.getBookId(), newAbstractBook);
    }

    public void lendBook(Reader reader, AbstractBook abstractBook) throws Exception {
        reader.borrowBook(abstractBook);
    }

    public void takeBackBook(Reader reader, AbstractBook abstractBook) throws Exception {
        reader.returnBook(abstractBook);
    }

    public void addReaderRecord(AbstractMemberRecord abstractMemberRecord){
        this.memberRecordsMap.put(abstractMemberRecord.getMemberId(), abstractMemberRecord);
    }

    public void removeReader(AbstractMemberRecord abstractMemberRecord){
        this.memberRecordsMap.remove(abstractMemberRecord.getMemberId());
    }

    public void addLibrarian(AbstractPerson librarian){
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

    public Librarian findLibrarianByNameAndPassword(String name, String password){
        Set<Long> keySet = this.librariansMap.keySet();
        for(Long key:keySet){
            if(this.librariansMap.get(key).getName().equals(name) && this.librariansMap.get(key).getPassword().equals(password)){
                return this.librariansMap.get(key);
            }
        }
        return null;
    }

    public AbstractMemberRecord findMemberByBook(AbstractBook abstractBook){
        Set<Long> keySet = this.memberRecordsMap.keySet();
        for(Long key:keySet){
            List<AbstractBook> membersAbstractBooks = this.memberRecordsMap.get(key).getMembersBooks();
            for(AbstractBook membersAbstractBook : membersAbstractBooks){
                if(membersAbstractBook.equals(abstractBook)){
                    return memberRecordsMap.get(key);
                }
            }
        }
        return null;
    }

    public boolean hasBook(Long bookId){
        if(this.librariansMap.containsKey(bookId)) return true;
        else return false;
    }


    @Override
    public String toString() {
        return "Library" + "\n" +
                "Books: " + this.libraryBooksMap + "\n" +
                "Member Records: " + this.memberRecordsMap + "\n" +
                "Librarians: " + this.librariansMap;
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
