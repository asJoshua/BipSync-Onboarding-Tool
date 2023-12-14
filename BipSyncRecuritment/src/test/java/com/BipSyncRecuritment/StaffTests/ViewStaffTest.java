package com.BipSyncRecuritment.StaffTests;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class ViewStaffTest {
    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldGetStaffList() throws Exception {
        MvcResult result = mvc
                .perform(get("/Staff"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);

        // Add more assertions as needed for your specific staff information
        assertTrue(content.contains("Heather"));
        assertTrue(content.contains("Perkins"));
        assertTrue(content.contains("Hr Manager"));
        assertTrue(content.contains("HeatherHR@bipsync.com"));

        assertTrue(content.contains("Ben"));
        assertTrue(content.contains("Shariff"));
        assertTrue(content.contains("IT Manager"));
        assertTrue(content.contains("BenShariffIT@bipsync.com"));

        assertTrue(content.contains("Adrian"));
        assertTrue(content.contains("Pennington"));
        assertTrue(content.contains("Senior software developer"));
        assertTrue(content.contains("Pemmigton@bipsync.com"));

        assertTrue(content.contains("Chau"));
        assertTrue(content.contains("mai"));
        assertTrue(content.contains("Marketing Director"));
        assertTrue(content.contains("ChaiMai@bipsync.com"));

        assertTrue(content.contains("Bill"));
        assertTrue(content.contains("Smith"));
        assertTrue(content.contains("Data Analyst"));
        assertTrue(content.contains("BillSmithData@bipsync.com"));

        assertTrue(content.contains("Luke"));
        assertTrue(content.contains("Jones"));
        assertTrue(content.contains("Dev ops"));
        assertTrue(content.contains("LukeJonesDevOps@bipsync.com"));
    }
}