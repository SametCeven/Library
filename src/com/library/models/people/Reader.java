package com.library.models.people;
import com.library.models.books.AbstractBook;
import com.library.models.books.Status;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Reader extends AbstractPerson {
    private Map<Long, AbstractBook> readersBooksMap;


    public Reader(String name) {
        super(name);
        this.readersBooksMap = new HashMap<>();
    }


    @Override
    public String toString(){
        return "Reader Name: " + super.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reader reader = (Reader) o;
        return this.readersBooksMap.equals(reader.readersBooksMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.readersBooksMap);
    }



    public void purchaseBook(AbstractBook abstractBook) throws Exception {
        if(this.readersBooksMap.size()<=5 && abstractBook.getStatus().equals(Status.AVAILABLE)){
            this.readersBooksMap.put(abstractBook.getBookId(), abstractBook);
            abstractBook.setStatus(Status.SOLD);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot purchase more.");
        }
    }

    public void borrowBook(AbstractBook abstractBook) throws Exception{
        if(this.readersBooksMap.size()<=5 && abstractBook.getStatus().equals(Status.AVAILABLE)){
            this.readersBooksMap.put(abstractBook.getBookId(), abstractBook);
            abstractBook.setStatus(Status.LENT);
        }else{
            throw new Exception("Reader has more than 5 books, and cannot borrow more.");
        }
    }

    public void returnBook(AbstractBook abstractBook) throws Exception{
        if(this.readersBooksMap.containsKey(abstractBook.getBookId())){
            this.readersBooksMap.remove(abstractBook.getBookId());
            abstractBook.setStatus(Status.AVAILABLE);
        }else{
            throw new Exception("Reader does not have the book to be returned.");
        }
    }


}
