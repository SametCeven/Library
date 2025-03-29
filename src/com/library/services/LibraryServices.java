package com.library.services;
import com.library.models.books.Book;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;
import com.library.models.people.Librarian;
import com.library.models.people.Person;
import com.library.models.people.Reader;
import java.util.Set;

public class LibraryServices {
    Library library;

    public void addBook(Book newBook){
        this.library.getLibrariesBooksMap().put(newBook.getBookId(),newBook);
    }

    public void lendBook(Reader reader, Book book) throws Exception {
        reader.borrowBook(book);
    }

    public void takeBackBook(Reader reader,Book book) throws Exception {
        reader.returnBook(book);
    }

    public void addReaderRecord(MemberRecord memberRecord){
        this.library.getMemberRecordsMap().put(memberRecord.getMemberId(),memberRecord);
    }

    public void removeReader(MemberRecord memberRecord){
        this.library.getMemberRecordsMap().remove(memberRecord.getMemberId());
    }

    public void addLibrarian(Person librarian){
        Librarian librarian1 = (Librarian) librarian;
        this.library.getLibrarianMap().put(librarian1.getId(),librarian1);
    }

    public void removeLibrarian(Librarian librarian){
        this.library.getLibrarianMap().remove(librarian.getId());
    }

    public boolean hasLibrarian(Librarian librarian){
        return this.library.getLibrarianMap().containsValue(librarian);
    }

    public boolean hasMember(Long memberId){
        return this.library.getMemberRecordsMap().containsKey(memberId);
    }

    public void showLibraryBooks(){
        Set<Long> libraryBooksMapKeys = this.library.getLibrariesBooksMap().keySet();
        for(Long libraryBooksMapKey:libraryBooksMapKeys){
            this.library.getLibrariesBooksMap().get(libraryBooksMapKey).showBook();
        }
    }

}
