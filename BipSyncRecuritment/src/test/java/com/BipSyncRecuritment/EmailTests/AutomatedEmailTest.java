package com.BipSyncRecuritment.EmailTests;


import com.BipSyncRecuritment.email.AutomatedEmailService;
import com.BipSyncRecuritment.email.EmailService;
import com.BipSyncRecuritment.employees.Employee;
import com.BipSyncRecuritment.employees.EmployeeService;
import com.BipSyncRecuritment.employees.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AutomatedEmailTest {

    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private AutomatedEmailService automatedEmailService;

    @Test
    public void testSendEmailIsDueInOneDay() {
        LocalDate aDayBefore = LocalDate.now().plusDays(1);
        //Given
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("Test");

        Task task = new Task();
        task.setTaskName("Test");
        task.setTaskResponsibility("Test");
        task.setTaskDueDate(aDayBefore);
        task.setTaskDepartmentEmail("Test@Test.com");

        employee.setTasks(new HashSet<>(Collections.singletonList(task)));

        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));

        // When
        automatedEmailService.sendEmailIsDueInOneDay();
        //Then
        verify(emailService, times(1)).sendEmail(eq("Test@Test.com"), anyString(), anyString());
    }

    @Test
    public void testSendEmailIsDueInOneWeek() {
        LocalDate aWeekBefore = LocalDate.now().plusDays(7);
        //Given
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("Test");

        Task task = new Task();
        task.setTaskName("Test");
        task.setTaskResponsibility("Test");
        task.setTaskDueDate(aWeekBefore);
        task.setTaskDepartmentEmail("Test@Test.com");

        employee.setTasks(new HashSet<>(Collections.singletonList(task)));

        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));

        // When
        automatedEmailService.sendEmailIsDueInOneWeek();
        //Then
        verify(emailService, times(1)).sendEmail(eq("Test@Test.com"), anyString(), anyString());
    }


    @Test
    public void testSendEmailIsOverDueByOneDay() {
        LocalDate aDayAfter = LocalDate.now().plusDays(-1);
        //Given
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("Test");

        Task task = new Task();
        task.setTaskName("Test");
        task.setTaskResponsibility("Test");
        task.setTaskDueDate(aDayAfter);
        task.setTaskDepartmentEmail("Test@Test.com");

        employee.setTasks(new HashSet<>(Collections.singletonList(task)));

        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));

        // When
        automatedEmailService.sendEmailIsOverDueByOneDay();
        //Then
        verify(emailService, times(1)).sendEmail(eq("Test@Test.com"), anyString(), anyString());
    }


    @Test
    public void testSendEmailIsOverDueByOneWeek() {
        LocalDate aDayAfter = LocalDate.now().plusDays(-7);
        //Given
        Employee employee = new Employee();
        employee.setFirstName("Test");
        employee.setLastName("Test");

        Task task = new Task();
        task.setTaskName("Test");
        task.setTaskResponsibility("Test");
        task.setTaskDueDate(aDayAfter);
        task.setTaskDepartmentEmail("Test@Test.com");

        employee.setTasks(new HashSet<>(Collections.singletonList(task)));

        when(employeeService.getAllEmployees()).thenReturn(Collections.singletonList(employee));

        // When
        automatedEmailService.sendEmailIsOverDueByOneWeek();
        //Then
        verify(emailService, times(1)).sendEmail(eq("Test@Test.com"), anyString(), anyString());
    }
    }


