package com.BipSyncRecuritment.NewRecruitTests;

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
public class ViewRecruitDetailsTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldDisplayRecruit1Details() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee/1/details"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Emily"));
        assertTrue(content.contains("Thompson"));
        assertTrue(content.contains("Software Engineer"));
        assertTrue(content.contains("0778823744"));

    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldDisplayRecruit2Details() throws Exception {
        MvcResult result = mvc
                .perform(get("/employee/2/details"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        System.out.println(content);
        assertTrue(content.contains("Ethan"));
        assertTrue(content.contains("Rodriguez"));
        assertTrue(content.contains("Data Analyst"));
        assertTrue(content.contains("07876145523"));
    }
}
