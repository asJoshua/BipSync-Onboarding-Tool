package com.BipSyncRecuritment.newRecruit;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class NewRecruitForm {

    private Long recruitId;

    @NotEmpty(message = "The first name cannot be empty")
    private String firstName;

    @NotEmpty(message = "The last name cannot be empty")
    private String lastName;

    private String dateOfBirth;

    @NotEmpty(message = "The phone number cannot be empty")
    private String phoneNumber;

    @NotEmpty(message = "The passport number cannot be empty")
    private String passportNumber;

    @NotEmpty(message = "The national insurance number cannot be empty")
    private String nationalInsuranceNumber;

    @NotEmpty(message = "The email cannot be empty")
    private String email;

    @NotEmpty(message = "The position cannot be empty")
    private String position;

    private String dateOfHire;

    @NotEmpty(message = "The emergency contact name cannot be empty")
    private String emergencyContactName;

    @NotEmpty(message = "The emergency contact phone number cannot be empty")
    private String emergencyContactPhoneNumber;

    public NewRecruitForm() {
        this(0L, "", "", "", "", "", "", "", "", "", "", "");
    }
}
