package com.BipSyncRecuritment.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long > {

    List<Task> findByTaskName(String taskName);
    List<Task> findByTaskDueDateBefore(LocalDate currentDate);
    List<Task> findByTaskDueDateAfter(LocalDate currentDate);
    Task findById(long id);
    @Query("SELECT e.firstName FROM Employee e JOIN Task et ON e.recruitId = et.taskId WHERE et.taskId = :taskId")
    String findEmployeeNameByTaskId(@Param("taskId") Long taskId);
}
