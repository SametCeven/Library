package com.library.services;
import com.library.models.books.Book;
import com.library.models.core.Library;
import com.library.models.members.MemberRecord;
import com.library.models.people.Author;
import com.library.models.people.Librarian;
import com.library.models.people.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LibrarianServices {
    Librarian librarian;
    Library library;
    private Map<Long, MemberRecord> memberRecordMap;

    public Book searchBook(Long bookId){
        return library.getLibrariesBooksMap().get(bookId);
    }

    public Book searchBook(String bookName) {
        Set<Long> booksMapKeys = library.getLibrariesBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(library.getLibrariesBooksMap().get(bookMapKey).getName().equals(bookName)){
                return library.getLibrariesBooksMap().get(bookMapKey);
            }
        }
        return null;
    }

    public List<Book> searchBook(Author authorName){
        List<Book> foundBooks = new ArrayList<>();
        Set<Long> booksMapKeys = library.getLibrariesBooksMap().keySet();
        for(Long bookMapKey:booksMapKeys){
            if(library.getLibrariesBooksMap().get(bookMapKey).getAuthor().getName().equals(authorName.getName())){
                foundBooks.add(library.getLibrariesBooksMap().get(bookMapKey));
            }
        }
        return foundBooks;
    }

    public boolean verifyMember(Long memberId){
        if (memberRecordMap.containsKey(memberId)) return true;
        else return false;
    }

    public void issueBook(Book book){
        library.getLibrariesBooksMap().put(book.getBookId(),book);
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
