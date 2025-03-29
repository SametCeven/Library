package com.library.models.core;
import com.library.models.books.Book;
import com.library.models.members.MemberRecord;
import com.library.models.people.*;
import java.util.*;


public class Library implements Comparable<Library> {
    private Long libraryId;
    private Map<Long, Book> librariesBooksMap;
    private Map<Long,MemberRecord> memberRecordsMap;
    private Map<Long, Librarian> librariansMap;

    public Library(Long libraryId){
        this.setLibraryId(libraryId);
        this.librariesBooksMap = new HashMap<>();
        this.memberRecordsMap = new HashMap<>();
        this.librariansMap = new HashMap<>();
    }

    public Long getLibraryId() {
        return libraryId;
    }
    public Map<Long, Book> getLibrariesBooksMap() {
        return this.librariesBooksMap;
    }
    public Map<Long,MemberRecord> getMemberRecordsMap() {
        return this.memberRecordsMap;
    }
    public Map<Long,Librarian> getLibrarianMap() {
        return this.librariansMap;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "Library{" +
                "booksMap=" + this.librariesBooksMap +
                ", memberRecordsMap=" + this.memberRecordsMap +
                ", librariansMap=" + this.librariansMap +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Library library = (Library) obj;
        return this.libraryId.equals(library.getLibraryId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.libraryId);
    }

    @Override
    public int compareTo(Library o) {
        return this.libraryId.compareTo(o.getLibraryId());
    }
}
