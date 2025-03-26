package com.library.books;
import java.util.Date;
import java.util.Objects;

public abstract class Book {
    private Long bookId;
    private String author;
    private String name;
    private Double price;
    private Status status;
    private String edition;
    private Date dateOfPurchase;


    public Book(Long bookId, String author, String name, Double price, Status status, String edition, Date dateOfPurchase){
        setBookId(bookId);
        setAuthor(author);
        setName(name);
        setPrice(price);
        setStatus(status);
        setEdition(edition);
        setDateOfPurchase(dateOfPurchase);
    }
    public Book(Long bookId, String author, String name, Double price, Status status, String edition){
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
    public String getAuthor(){
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
    public void setBookId(Long bookId){
        if(bookId == null)
            throw new IllegalArgumentException("Book ID cannot be null.");
        this.bookId = bookId;
    }
    public void setAuthor(String author){
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


    @Override
    public String toString() {
        return "Book ID: " + bookId +
                " Author: " + author +
                " Name: " + name + " " +
                " Price: " + price +
                " Status: " + status +
                " Edition: " + edition +
                " Date Of Purchase: " + dateOfPurchase;
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




}
