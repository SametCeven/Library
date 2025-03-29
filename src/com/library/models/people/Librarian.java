package com.library.models.people;
import com.library.models.core.Library;
import com.library.services.LibrarianServices;
import com.library.services.LibraryServices;

import java.util.Objects;


public class Librarian extends Person implements Comparable<Librarian>{
    private Long id;
    private String password;
    private Library library;
    private LibraryServices libraryServices;

    public Librarian(Long id,String name, String password,Library library){
        super(name);
        this.setId(id);
        this.setPassword(password);
        this.library = library;
        libraryServices.addLibrarian(this);
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
    public String whoYouAre() {
        return "Name: " + super.getName();
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
        if(o == null || o.getClass() != this.getClass()) return false;
        Librarian librarian = (Librarian) o;
        return this.id.equals(librarian.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Librarian o) {
        return this.id.compareTo(o.getId());
    }


}
