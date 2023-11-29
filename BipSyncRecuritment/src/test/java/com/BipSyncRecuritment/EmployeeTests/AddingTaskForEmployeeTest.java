package com.BipSyncRecuritment.EmployeeTests;

import com.BipSyncRecuritment.employees.Task;
import com.BipSyncRecuritment.employees.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AddingTaskForEmployeeTest {
    @Autowired
    private TaskService taskService;

    @Test
    public void shouldGetNineItemsAfterAddingOne() throws Exception {
        Task newTask = new Task("Add Employee to Calendar", LocalDate.of(2023, 12, 23), "HR");
        taskService.saveTask(newTask);

        List<Task> tasks = taskService.getAllTasks();

        assertEquals(9, tasks.size());
    }

}
