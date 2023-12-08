package com.BipSyncRecuritment.EmployeeTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ViewEmployeeTaskListTest {

    @Autowired
    private MockMvc mvc;



    //test for displaying tasks for employee id = 1
    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldDisplayTwoTasks() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Add to Company group lists and calenders"));
        assertTrue(content.contains("2023-12-20"));
        assertTrue(content.contains("HR"));
        assertTrue(content.contains("Prepare Contracts"));
        assertTrue(content.contains("2023-12-15"));
        assertTrue(content.contains("HR"));


    }
    //test for displaying tasks for employee id = 2
    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldDisplayOneTask() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Sign contracts,tax forms"));
        assertTrue(content.contains("2023-12-18"));
        assertTrue(content.contains("HR"));



    }
    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldDisplayOneTaskForEmployeeThree() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Ensure correct IT equipment is updated and ready to use"));
        assertTrue(content.contains("2023-12-28"));
        assertTrue(content.contains("IT"));



    }
    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldDisplayTwoTaskForEmployeeFour() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee/4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Set up Desk"));
        assertTrue(content.contains("2023-12-28"));
        assertTrue(content.contains("Facilities"));
        assertTrue(content.contains("Create email accounts"));
        assertTrue(content.contains("2023-12-17"));
        assertTrue(content.contains("IT"));



    }
    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldDisplayOneTaskForEmployeeFive() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee/5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Check confirmation of work permits"));
        assertTrue(content.contains("2023-12-14"));
        assertTrue(content.contains("HR"));



    }



}
