package com.library.models.members;
import com.library.models.books.AbstractBook;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public abstract class AbstractMemberRecord {
    private Long memberId;
    private String name;
    private Type type;
    private Date dateOfMembership;
    private Integer noBooksIssued;
    private static final int MAX_BOOK_LIMIT = 5;
    private String address;
    private String phoneNumber;
    private List<AbstractBook> membersAbstractBooks;

    public AbstractMemberRecord(Long memberId, String name, Type type, Date dateOfMembership, Integer noBooksIssued, String address, String phoneNumber) {
        this.setMemberId(memberId);
        this.setName(name);
        this.setType(type);
        this.setDateOfMembership(dateOfMembership);
        this.setNoBooksIssued(noBooksIssued);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        membersAbstractBooks = new ArrayList<>();
    }

    public Long getMemberId() {
        return this.memberId;
    }
    public String getName() {
        return this.name;
    }
    public Type getType() {
        return this.type;
    }
    public Date getDateOfMembership() {
        return this.dateOfMembership;
    }
    public Integer getNoBooksIssued() {
        return this.noBooksIssued;
    }
    public static int getMaxBookLimit() {
        return MAX_BOOK_LIMIT;
    }
    public String getAddress() {
        return this.address;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public List<AbstractBook> getMembersBooks() {
        return this.membersAbstractBooks;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }
    public void setNoBooksIssued(Integer noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "MemberRecord" + "\n" +
                "Member ID: " + this.memberId + "\n" +
                "Name: " + this.name + "\n" +
                "Type: " + this.type + '\'' + "\n" +
                "Date of Membership: " + this.dateOfMembership + "\n" +
                "Number of Books Issued: " + this.noBooksIssued + "\n" +
                "Max Book Limit: " + this.MAX_BOOK_LIMIT + "\n" +
                "Address: " + this.address + "\n" +
                "Phone Number: " + this.phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        AbstractMemberRecord newObj = (AbstractMemberRecord) obj;
        return this.memberId.equals(newObj.getMemberId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.memberId);
    }

    public void incBookIssued(){
        this.noBooksIssued++;
    }

    public void decBookIssued(){
        this.noBooksIssued--;
    }

    public void addBookToMember(AbstractBook abstractBook){
        this.membersAbstractBooks.add(abstractBook);
        this.incBookIssued();
    }

    public void removeBookFromMember(AbstractBook abstractBook){
        this.membersAbstractBooks.remove(abstractBook);
        this.decBookIssued();
    }

    public void showMembersBooks(){
        for(AbstractBook abstractBook: this.membersAbstractBooks){
            System.out.println(
                    "Book ID: " + abstractBook.getBookId() + ", " +
                    "Name: " + abstractBook.getName() + ", " +
                    abstractBook.getAuthor() + ", " +
                    abstractBook.getStatus());
            }
    }



}
