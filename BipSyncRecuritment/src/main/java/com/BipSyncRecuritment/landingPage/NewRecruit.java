package com.BipSyncRecuritment.landingPage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewRecruit {
    private Long id;
    private String firstName;
    private String lastName;
    private String DoB;
    private int phoneNumber;
    private int passportNumber;
    private int nationalInsuranceNumber;
    private String email;
    private String position;
    private String dateOfHire;
    private String emergencyContactName;
    private String emergencyContactPhoneNumber;

    public NewRecruit() {
        this(0L, "", "", "", "", "", "", "", "", "", "", "");
    }
    public boolean isNew() {
        return this.id == 0;
    }
}



