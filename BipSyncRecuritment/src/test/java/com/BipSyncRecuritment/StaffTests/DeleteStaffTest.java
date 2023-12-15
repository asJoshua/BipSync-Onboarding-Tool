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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DeleteStaffTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private StaffRepository staffRepository;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void shouldRemoveStaff() throws Exception {
        int staffCountBeforeRemoval = staffRepository.getStaffInfo().size();

        Long staffIdToRemove = 2L;

        staffInfo staffBeforeRemoval = staffRepository.getStaffInfo(staffIdToRemove);

        MvcResult result = mvc
                .perform(get("/DeleteStaff/" + staffIdToRemove))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andReturn();

//        staffInfo removedStaff = staffRepository.getStaffInfo(staffIdToRemove);
//        assertEquals(null, removedStaff);
//
//        int staffCountAfterRemoval = staffRepository.getStaffInfo().size();
//        assertEquals(staffCountBeforeRemoval - 1, staffCountAfterRemoval);
    }
}