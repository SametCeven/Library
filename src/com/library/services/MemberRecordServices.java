package com.library.services;
import com.library.models.members.MemberRecord;

public class MemberRecordServices {

    private MemberRecord memberRecord;

    public void getMember(){
        System.out.println(
                "Member Name: " + this.memberRecord.getName()
        );
    }

    public void incBookIssued(){
        this.memberRecord.setNoBooksIssued(memberRecord.getNoBooksIssued()+1);
    }

    public void decBookIssued(){
        this.memberRecord.setNoBooksIssued(memberRecord.getNoBooksIssued()-1);
    }

    public void payBill(){

    }


}
