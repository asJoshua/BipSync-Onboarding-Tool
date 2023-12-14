package com.BipSyncRecuritment.StaffTests;

import com.BipSyncRecuritment.Staff.StaffRepository;
import com.BipSyncRecuritment.Staff.staffInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EditStaffTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StaffRepository staffRepository;  // Make sure to inject the actual repository here

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldEditStaff() throws Exception {
        Long staffIdToEdit = 1L;

        MvcResult result = mvc
                .perform(post("/Staff/edit/" + staffIdToEdit)
                        .param("name", "AMAN")  // Change the name here
                        .param("lastName", "Perkins")
                        .param("email", "HeatherPerkins@Bipsync.com")
                        .param("role", "Hr Manager"))
                .andDo(print())
                .andExpect(status().is3xxRedirection()) // Assuming you are redirecting after a successful edit
                .andReturn();

        staffInfo editedStaff = staffRepository.getStaffInfo(staffIdToEdit);
        assertEquals("AMAN", editedStaff.getName());  // Check the updated name here
        assertEquals("Perkins", editedStaff.getLastName());
        assertEquals("HeatherPerkins@Bipsync.com", editedStaff.getEmail());
        assertEquals("Hr Manager", editedStaff.getRole());
    }
}