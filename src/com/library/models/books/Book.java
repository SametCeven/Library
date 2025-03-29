package com.library.models.books;
import com.library.models.members.MemberRecord;
import com.library.models.people.Author;
import com.library.models.people.Person;
import java.util.Date;
import java.util.Objects;


public abstract class Book implements Comparable<Book>{
    private Long bookId;
    private Person author;
    private String name;
    private Double price;
    private Status status;
    private String edition;
    private Date dateOfPurchase;
    private MemberRecord owner;


    public Book(Long bookId, Person author, String name, Double price, Status status, String edition, Date dateOfPurchase){
        this.setBookId(bookId);
        this.setAuthor(author);
        ((Author)author).addBook(this);
        this.setName(name);
        this.setPrice(price);
        this.setStatus(status);
        this.setEdition(edition);
        this.setDateOfPurchase(dateOfPurchase);
    }
    public Book(Long bookId, Person author, String name, Double price, Status status, String edition){
        this.setBookId(bookId);
        this.setAuthor(author);
        ((Author)author).addBook(this);
        this.setName(name);
        this.setPrice(price);
        this.setStatus(status);
        this.setEdition(edition);
        this.setDateOfPurchase(new Date());
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
    public MemberRecord getOwner(){
        return owner;
    }
    public void setBookId(Long bookId){
        if(bookId == null) throw new IllegalArgumentException("Book ID cannot be null.");
        this.bookId = bookId;
    }
    public void setAuthor(Person author){
        if(author == null) throw new IllegalArgumentException("Author cannot be null.");
        this.author = author;
    }
    public void setName(String name){
        if(name == null) throw new IllegalArgumentException("Name cannot be null.");
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
    public void setOwner(MemberRecord owner){
        if(owner == null) throw new IllegalArgumentException("Owner cannot be null.");
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + this.bookId +
                ", author=" + this.author +
                ", name='" + this.name + '\'' +
                ", price=" + this.price +
                ", status=" + this.status +
                ", edition='" + this.edition + '\'' +
                ", dateOfPurchase=" + this.dateOfPurchase +
                ", owner=" + this.owner +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return this.bookId.equals(book.getBookId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.bookId);
    }
    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
    }




    public void showBook() {
        System.out.println(
                "Book ID: " + this.bookId + "," +
                        " Name: " + this.name + ", " +
                        this.author);
    }
    public void changeOwner(Book book,MemberRecord newOwner) throws Exception{

    }
    public void updateStatus(){

    }



}
