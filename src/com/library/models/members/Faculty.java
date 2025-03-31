package com.library.models.members;
import java.util.Date;


public class Faculty extends AbstractMemberRecord {
    public Faculty(Long memberId, String name, Date dateOfMembership, Integer noBooksIssued, String address, String phoneNumber) {
        super(memberId, name, Type.FACULTY, dateOfMembership, noBooksIssued, address, phoneNumber);
    }
}
