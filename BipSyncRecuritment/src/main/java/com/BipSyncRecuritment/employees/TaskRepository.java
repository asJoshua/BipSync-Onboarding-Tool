package com.BipSyncRecuritment.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long > {

    List<Task> findByTaskName(String taskName);
    Task findById(long id);
}
