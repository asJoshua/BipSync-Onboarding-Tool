package com.BipSyncRecuritment.RegisterStaffTests;

import com.BipSyncRecuritment.login.UserLoginDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.slf4j.MDC.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc

public class StaffAccessTest {

    @Autowired
    private MockMvc mvc;

        @Test
        //Given a  user who has role as staff is logged in
        @WithMockUser(username = "user", password = "user", roles = "STAFF")
        public void DeniedAccessToRegisterUsersPage() throws Exception {
            //when user navigates to register staff page
                    mvc.perform(MockMvcRequestBuilders.get("/registerStaff"))
                    .andDo(print())

          //then the user should be denied access to the page and redirect to the 403 error page.
                    .andExpect(status().isForbidden())
                    .andExpect(forwardedUrl("/403"));


        }
    @Test
    //Given a  user who has role as staff is logged in
    @WithMockUser(username = "user", password = "user", roles = "STAFF")
    public void DeniedAccessToNewRecruitPage() throws Exception {
        //when user navigates to new Recruit page
        mvc.perform(MockMvcRequestBuilders.get("/newRecruit"))
                .andDo(print())

                //then the user should be denied access to the page and redirect to the 403 error page.
                .andExpect(status().isForbidden())
                .andExpect(forwardedUrl("/403"));


    }
    @Test
    //Given a  user who has role as staff is logged in
    @WithMockUser(username = "user", password = "user", roles = "STAFF")
    public void DeniedAccessToEmployeeDetailsPage() throws Exception {

        //when user navigates to employee page and click view details for employee with id 1
        Long recruitId = 1L;
        mvc.perform(MockMvcRequestBuilders.get("/employee/{recruitId}/details",recruitId))
                .andDo(print())

                //then the user should be denied access to the page and redirect to the 403 error page.
                .andExpect(status().isForbidden())
                .andExpect(forwardedUrl("/403"));

    }

    @Test
    //Given a  user who has role as staff is logged in
    @WithMockUser(username = "user", password = "user", roles = "STAFF")
    public void DeniedAccessToMarkTaskAsCompleted() throws Exception {

        //when user navigates to employee page and clicks view tasks for employee with id = 1 and clicks mark as complete on task with id =1
        Long recruitId = 1L;
        Long taskId = 1L;
        mvc.perform(MockMvcRequestBuilders.get("/employee/{recruitId}/remove-task/{taskId}",recruitId,taskId))
                .andDo(print())

                //then the user should be denied access to the page and redirect to the 403 error page.
                .andExpect(status().isForbidden())
                .andExpect(forwardedUrl("/403"));

    }

    @Test
    //Given a  user who has role as staff is logged in
    @WithMockUser(username = "user", password = "user", roles = "STAFF")
    public void DeniedAccessToAddATask() throws Exception {

        //when user navigates to view tasks for employee with id 1 page and clicks on add a task
        Long recruitId = 1L;
        mvc.perform(MockMvcRequestBuilders.get("/employee/{recruitId}/add-task",recruitId))
                .andDo(print())

                //then the user should be denied access to the page and redirect to the 403 error page.
                .andExpect(status().isForbidden())
                .andExpect(forwardedUrl("/403"));

    }



}

