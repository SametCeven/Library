package com.library.models.books;
import com.library.models.members.AbstractMemberRecord;
import com.library.models.people.Author;
import com.library.models.people.AbstractPerson;
import java.util.Date;
import java.util.Objects;


public abstract class AbstractBook implements Comparable<AbstractBook>{
    private Long bookId;
    private AbstractPerson author;
    private String name;
    private Double price;
    private Status status;
    private String edition;
    private Date dateOfPurchase;
    private AbstractMemberRecord owner;


    public AbstractBook(Long bookId, AbstractPerson author, String name, Double price, Status status, String edition, Date dateOfPurchase){
        this.setBookId(bookId);
        this.setAuthor(author);
        ((Author)author).addBook(this);
        this.setName(name);
        this.setPrice(price);
        this.setStatus(status);
        this.setEdition(edition);
        this.setDateOfPurchase(dateOfPurchase);
    }
    public AbstractBook(Long bookId, AbstractPerson author, String name, Double price, Status status, String edition){
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
        return this.bookId;
    }
    public String getName(){
        return this.name;
    }
    public AbstractPerson getAuthor(){
        return this.author;
    }
    public Double getPrice(){
        return this.price;
    }
    public Status getStatus(){
        return this.status;
    }
    public String getEdition(){
        return this.edition;
    }
    public Date getDateOfPurchase(){
        return this.dateOfPurchase;
    }
    public AbstractMemberRecord getOwner(){
        return this.owner;
    }

    public void setBookId(Long bookId){
        if(bookId == null) throw new IllegalArgumentException("Book ID cannot be null.");
        this.bookId = bookId;
    }
    public void setAuthor(AbstractPerson author){
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
    public void setOwner(AbstractMemberRecord owner){
        if(owner == null) throw new IllegalArgumentException("Owner cannot be null.");
        this.owner = owner;
    }


    @Override
    public String toString() {
        return "Book:" + "\n" +
                "Book ID: " + this.bookId + "\n" +
                "Author Name: " + this.author + "\n" +
                "Name: " + this.name + "\n" +
                "Price: " + this.price + "\n" +
                "Status: " + this.status + "\n" +
                "Edition: " + this.edition + "\n" +
                "Date of Purchase: " + this.dateOfPurchase + "\n" +
                "Owner: " + this.owner + "\n";
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        AbstractBook abstractBook = (AbstractBook) o;
        return this.bookId.equals(abstractBook.getBookId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.bookId);
    }

    @Override
    public int compareTo(AbstractBook o) {
        return this.name.compareTo(o.name);
    }




    public void showBook() {
        System.out.println(
                "Book ID: " + this.bookId + ", " +
                "Name: " + this.name + ", " +
                this.author + ", " +
                this.status);
    }

    public void changeOwner(AbstractMemberRecord newOwner, AbstractMemberRecord oldOwner){
        this.owner = newOwner;
        newOwner.addBookToMember(this);
        oldOwner.removeBookFromMember(this);
    }



}
