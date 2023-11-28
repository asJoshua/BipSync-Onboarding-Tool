package com.BipSyncRecuritment.employees;

import jakarta.persistence.*;

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
    private LocalDate taskDueDate;

    @Column(name = "task_responsibility")
    private String taskResponsiblity;

    @ManyToMany(mappedBy = "tasks")
    private Set<Employee> employees = new HashSet<>();

    public Task(){};
    public void setTaskId(Long id) {
        this.taskId = id;
    }

    public Long getTaskId() {
        return taskId;
    }
public Task(String taskName){
        this.taskName = taskName;
}




    public String getTaskName() {
        return taskName;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }

    public String getTaskResponsiblity() {
        return taskResponsiblity;
    }
}
