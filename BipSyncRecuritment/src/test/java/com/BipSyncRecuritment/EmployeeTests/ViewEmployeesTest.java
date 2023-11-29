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
public class ViewEmployeesTest {

    @Autowired
    private MockMvc mvc;


    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldGetFiveEmployees() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Emily"));
        assertTrue(content.contains("Thompson"));
        assertTrue(content.contains("Software Engineer"));
        assertTrue(content.contains("thompson@bipsync.com"));

        assertTrue(content.contains("Ethan"));
        assertTrue(content.contains("Rodriguez"));
        assertTrue(content.contains("Data Analyst"));
        assertTrue(content.contains("erodriguez@bipsync.com"));

        assertTrue(content.contains("Ava"));
        assertTrue(content.contains("Patel"));
        assertTrue(content.contains("Data Analyst"));
        assertTrue(content.contains("apatel@bipsync.com"));

        assertTrue(content.contains("Noah"));
        assertTrue(content.contains("Davis"));
        assertTrue(content.contains("Data Analyst"));
        assertTrue(content.contains("ndavis@bipsync.com"));

        assertTrue(content.contains("Harper"));
        assertTrue(content.contains("Mitchell"));
        assertTrue(content.contains("Software Engineer"));
        assertTrue(content.contains("apatel@bipsync.com"));
    }
}
