package com.BipSyncRecuritment.LoginTests;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testAdminLogin() throws Exception {
        // testdata for username and password is in database
        String encodedPassword = passwordEncoder.encode("test");


        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .param("username", "test")
                        .param("password", "test")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/home"));
    }
    @Test
    public void testInvalidAdminLogin() throws Exception {
        //the test1 data does not exist in database
        String encodedPassword = passwordEncoder.encode("test1");


        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .param("username", "test1")
                        .param("password", "test1")
                        .with(SecurityMockMvcRequestPostProcessors.csrf()))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login?error"));
    }


}
