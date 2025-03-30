package com.library.models.members;
import com.library.models.books.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public abstract class MemberRecord {
    private Long memberId;
    private String name;
    private Type type;
    private Date dateOfMembership;
    private Integer noBooksIssued;
    private static final Integer MAX_BOOK_LIMIT = 5;
    private String address;
    private String phoneNumber;
    private List<Book> membersBooks;

    public MemberRecord(Long memberId, String name, Type type, Date dateOfMembership, Integer noBooksIssued, String address, String phoneNumber) {
        setMemberId(memberId);
        setName(name);
        setType(type);
        setDateOfMembership(dateOfMembership);
        setNoBooksIssued(noBooksIssued);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        membersBooks = new ArrayList<>();
    }

    public Long getMemberId() {
        return memberId;
    }
    public String getName() {return name;}
    public Type getType() {return type;}
    public Date getDateOfMembership() {
        return dateOfMembership;
    }
    public Integer getNoBooksIssued() {
        return noBooksIssued;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public List<Book> getMembersBooks() {
        return membersBooks;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public void setName(String name) {this.name = name;}
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
        return "MemberRecord{" +
                "memberId=" + memberId +
                " name=" + name +
                ", type='" + type + '\'' +
                ", dateOfMembership=" + dateOfMembership +
                ", noBooksIssued=" + noBooksIssued +
                ", maxBookLimit=" + MAX_BOOK_LIMIT +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void getMember(){

    }
    public void incBookIssued(){
        this.noBooksIssued++;
    }
    public void decBookIssued(){
        this.noBooksIssued--;
    }
    public void payBill(){

    }
    public void addBookToMember(Book book){
        membersBooks.add(book);
    }
    public void removeBookFromMember(Book book){
        membersBooks.remove(book);
    }


}
