package com.BipSyncRecuritment.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long > {

    List<Task> findByTaskName(String taskName);
    List<Task> findByTaskDueDateBefore(LocalDate currentDate);
    List<Task> findByTaskDueDateAfter(LocalDate currentDate);
    Task findById(long id);
}
