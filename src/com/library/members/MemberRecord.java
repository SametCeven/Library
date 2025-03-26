package com.library.members;

import java.util.Date;

public class MemberRecord {
    private Long memberId;
    private Type type;
    private Date dateOfMembership;
    private Integer noBooksIssued;
    private static final Integer MAX_BOOK_LIMIT = 5;
    private String name;
    private String address;
    private String phoneNumber;

    public MemberRecord(Long memberId, Type type, Date dateOfMembership, Integer noBooksIssued, String name, String address, String phoneNumber) {
        setMemberId(memberId);
        setType(type);
        setDateOfMembership(dateOfMembership);
        setNoBooksIssued(noBooksIssued);
        setName(name);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    public Long getMemberId() {
        return memberId;
    }
    public Type getType() {
        return type;
    }
    public Date getDateOfMembership() {
        return dateOfMembership;
    }
    public Integer getNoBooksIssued() {
        return noBooksIssued;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
    public void setName(String name) {
        this.name = name;
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
                ", type='" + type + '\'' +
                ", dateOfMembership=" + dateOfMembership +
                ", noBooksIssued=" + noBooksIssued +
                ", maxBookLimit=" + MAX_BOOK_LIMIT +
                ", name='" + name + '\'' +
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


}
