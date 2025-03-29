package com.library.models.people;
import com.library.models.books.Book;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Reader extends Person implements Comparable<Reader>{
    private Map<Long,Book> readersBooksMap;


    public Reader(String name) {
        super(name);
        this.readersBooksMap = new HashMap<>();
    }

    public Map<Long, Book> getReadersBooksMap() {
        return readersBooksMap;
    }

    @Override
    public String whoYouAre() {
        return "Reader: " + super.getName() + " Books: " + this.readersBooksMap;
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
        return Objects.hash(readersBooksMap);
    }

    @Override
    public int compareTo(Reader o) {
        return super.getName().compareTo(o.getName());
    }






}
