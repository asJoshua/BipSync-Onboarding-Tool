package com.BipSyncRecuritment.employees;
import jakarta.persistence.*;
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


