package com.library.members;

import java.util.Date;

public class Faculty extends MemberRecord {
    public Faculty(Long memberId, Date dateOfMembership, Integer noBooksIssued, String name, String address, String phoneNumber) {
        super(memberId, Type.FACULTY, dateOfMembership, noBooksIssued, name, address, phoneNumber);
    }
}
