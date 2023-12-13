package com.BipSyncRecuritment.newRecruit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class NewRecruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String phoneNumber;
    private String passportNumber;
    private String nationalInsuranceNumber;
    private String email;
    private String position;
    private String dateOfHire;
    private String emergencyContactName;
    private String emergencyContactPhoneNumber;

    public Long getRecruitId(){
        return recruitId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return  lastName;
    }

    public void setRecruitId(Long recruitId) {
        this.recruitId = recruitId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(String dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhoneNumber() {
        return emergencyContactPhoneNumber;
    }

    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    public boolean isNew() {
        return this.recruitId == 0;
    }
}
