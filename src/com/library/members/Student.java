package com.library.members;

import java.util.Date;

public class Student extends MemberRecord {
    public Student(Long memberId, Date dateOfMembership, Integer noBooksIssued, String name, String address, String phoneNumber) {
        super(memberId, Type.STUDENT, dateOfMembership, noBooksIssued, name, address, phoneNumber);
    }
}
