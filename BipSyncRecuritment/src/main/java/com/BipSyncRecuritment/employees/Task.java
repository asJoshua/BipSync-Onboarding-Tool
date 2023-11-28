package com.BipSyncRecuritment.employees;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    private  String taskName;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private LocalDate taskDueDate;

    @Column(name = "task_responsibility")
    private String taskResponsibility;

    @ManyToMany(mappedBy = "tasks")
    private Set<Employee> employees = new HashSet<>();

    public Task(){};
    public void setTaskId(Long id) {
        this.taskId = id;
    }

    public Long getTaskId() {
        return taskId;
    }
public Task(String taskName, LocalDate taskDueDate, String taskResponsibility){
        this.taskName = taskName;
        this.taskDueDate = taskDueDate;
        this.taskResponsibility=taskResponsibility;
}




    public String getTaskName() {
        return taskName;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public String getTaskResponsibility() {
        return taskResponsibility;
    }

    public String setTaskName(String taskName) {
        return this.taskName=taskName;
    }
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public LocalDate setTaskDueDate(LocalDate taskDueDate){
        return this.taskDueDate=taskDueDate;
    }

    public String setTaskResponsibility(String taskResponsibility){
        return this.taskResponsibility=taskResponsibility;
    }
}
