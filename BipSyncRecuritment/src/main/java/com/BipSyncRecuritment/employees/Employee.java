package com.BipSyncRecuritment.employees;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recruits")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;  // Change 'id' to 'recruitId'
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String passportNumber;
    private String nationalInsuranceNumber;
    private String email;
    private String position;
    private LocalDate dateOfHire;
    private String emergencyContactName;
    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhoneNumber;



    @ManyToMany
    @JoinTable(
            name = "employee_tasks",
            joinColumns = @JoinColumn(name = "t_recruit_id"),
            inverseJoinColumns = @JoinColumn(name = "t_task_id")
    )
    private Set<Task> tasks = new HashSet<>();

    public Set<Task> getTasks() {
        return tasks;
    }


    public void setRecruitId(Long id) {
        this.recruitId = id;
    }

    public Long getRecruitId() {
        return recruitId;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }
}


