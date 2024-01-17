package com.BipSyncRecuritment.CheckListTests;

import com.BipSyncRecuritment.employees.Task;
import com.BipSyncRecuritment.employees.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CheckTasksTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private TaskService taskService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldGetEthanAndEmilyTask() throws Exception {
        MvcResult result = mvc
                .perform(get("/home"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Ethan"));
        assertTrue(content.contains("Pending Overdue Test"));
        assertTrue(content.contains("2023-12-20"));
        assertTrue(content.contains("HR"));

        assertTrue(content.contains("Emily"));
        assertTrue(content.contains("Pending Dummy Test"));
        assertTrue(content.contains("2024-12-20"));
        assertTrue(content.contains("HR"));
    }

    @Test
    public void shouldGetThreeAfterAddingOneAndCheckOverdue() throws Exception {
        Task newTask = new Task("Test adding task", LocalDate.of(2023, 12, 23), "HR");
        taskService.saveTask(newTask);

        List<Task> tasks = taskService.getAllTasks();
        List<Task> overDueTasks = taskService.getOverdueTasks();

        assertEquals(3, tasks.size());
        assertEquals(2, overDueTasks.size());
    }
}
