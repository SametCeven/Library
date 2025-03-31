package com.library.models.members;
import java.util.Date;


public class Student extends AbstractMemberRecord {
    public Student(Long memberId, String name, Date dateOfMembership, Integer noBooksIssued, String address, String phoneNumber) {
        super(memberId, name, Type.STUDENT, dateOfMembership, noBooksIssued, address, phoneNumber);
    }
}
