package com.BipSyncRecuritment.employees;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "recruits")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruitId;
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;
    private LocalDate dateOfBirth;
    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneNumber;
    @NotEmpty(message = "Passport number cannot be empty")
    @Column
    private String passportNumber;
    @NotEmpty(message = "National Insurance Number cannot be empty")
    private String nationalInsuranceNumber;
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;
    @NotEmpty(message = "Position  cannot be empty")

    private String position;
    private LocalDate dateOfHire;
    @NotEmpty(message = "Emergency Contact Name cannot be empty")
    private String emergencyContactName;
    @NotEmpty(message = "Emergency Contact Number cannot be empty")
    @Column(name = "emergency_contact_phone")
    private String emergencyContactPhoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "employee_tasks",
            joinColumns = @JoinColumn(name = "t_recruit_id"),
            inverseJoinColumns = @JoinColumn(name = "t_task_id")
    )
    private Set<Task> tasks = new HashSet<>();

    public Set<Task> getTasks() {
        return tasks;
    }

    @ElementCollection
    @CollectionTable(name = "completed_tasks",
            joinColumns = @JoinColumn(name = "c_recruit_id"))
    @Column(name = "c_task_id")
    private Set<Long> completedTasks = new HashSet<>();

    public List<Task> getTasksOrderByDueDate() {
        return tasks.stream()
                .sorted(Comparator.comparing(Task::getTaskDueDate))
                .collect(Collectors.toList());
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
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }


    public void  setPosition(String position){
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassportNumber(){
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationalInsuranceNumber(){
        return nationalInsuranceNumber;
    }
public void setNationalInsuranceNumber(String nationalInsuranceNumber){
        this.nationalInsuranceNumber = nationalInsuranceNumber;
}
    public String getEmergencyContactName(){
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactPhoneNumber(){
        return emergencyContactPhoneNumber;
    }

    public void setEmergencyContactPhoneNumber(String emergencyContactPhoneNumber) {
        this.emergencyContactPhoneNumber = emergencyContactPhoneNumber;
    }

    public LocalDate getDateOfHire(){
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public Set<Long> getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(Set<Long> completedTasks) {
        this.completedTasks = completedTasks;
    }

    public void completeTask(Long taskId) {
        completedTasks.add(taskId);


    }
    public void removeTasks(Long taskId) {
        tasks.removeIf(task -> task.getTaskId().equals(taskId));
    }
}


