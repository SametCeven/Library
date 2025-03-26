package com.library.books;
import com.library.people.Person;
import com.library.people.Reader;

import java.util.Date;
import java.util.Objects;

public abstract class Book implements Comparable{
    private Long bookId;
    private Person author;
    private String name;
    private Double price;
    private Status status;
    private String edition;
    private Date dateOfPurchase;
    private Reader owner;


    public Book(Long bookId, Person author, String name, Double price, Status status, String edition, Date dateOfPurchase){
        setBookId(bookId);
        setAuthor(author);
        setName(name);
        setPrice(price);
        setStatus(status);
        setEdition(edition);
        setDateOfPurchase(dateOfPurchase);
    }
    public Book(Long bookId, Person author, String name, Double price, Status status, String edition){
        setBookId(bookId);
        setAuthor(author);
        setName(name);
        setPrice(price);
        setStatus(status);
        setEdition(edition);
        setDateOfPurchase(new Date());
    }


    public Long getBookId(){
        return bookId;
    }
    public String getName(){
        return name;
    }
    public Person getAuthor(){
        return author;
    }
    public Double getPrice(){
        return price;
    }
    public Status getStatus(){
        return status;
    }
    public String getEdition(){
        return edition;
    }
    public Date getDateOfPurchase(){
        return dateOfPurchase;
    }
    public Reader getOwner(){
        return owner;
    }
    public void setBookId(Long bookId){
        if(bookId == null)
            throw new IllegalArgumentException("Book ID cannot be null.");
        this.bookId = bookId;
    }
    public void setAuthor(Person author){
        if(author == null)
            throw new IllegalArgumentException("Author cannot be null.");
        this.author = author;
    }
    public void setName(String name){
        if(name == null)
            throw new IllegalArgumentException("Name cannot be null.");
        this.name = name;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setStatus(Status status){
        this.status = status;
    }
    public void setEdition(String edition){
        this.edition = edition;
    }
    public void setDateOfPurchase(Date dateOfPurchase){
        this.dateOfPurchase = dateOfPurchase;
    }
    public void setOwner(Reader owner){
        if(owner == null)
            throw new IllegalArgumentException("Owner cannot be null.");
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Book ID: " + bookId +
                " Author: " + author +
                " Name: " + name + " " +
                " Price: " + price +
                " Status: " + status +
                " Edition: " + edition +
                " Date Of Purchase: " + dateOfPurchase +
                "\n";
    }
    @Override
    public boolean equals(Object o){
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId);
        //return bookId.equals(book.bookId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
    @Override
    public int compareTo(Object o) {
        Book book = (Book) o;
        return name.compareTo(((Book) o).name);
    }


    public void changeOwner(Book book, Reader oldOwner, Reader newOwner) throws Exception{
        if(!oldOwner.showBook().containsKey(book.getBookId())) throw new Exception("Reader does not own the book.");
        if(newOwner.showBook().size()>5) throw new Exception("Reader would have more than 5 books.");
        oldOwner.returnBook(book);
        newOwner.borrowBook(book);
        setOwner(newOwner);
    }

    public String showBook(){
        return "Book ID: " + bookId + " Name: " + name + " Author: " + author;
    }




}
