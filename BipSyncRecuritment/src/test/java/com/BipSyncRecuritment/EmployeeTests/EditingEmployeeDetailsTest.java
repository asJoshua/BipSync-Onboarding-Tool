package com.BipSyncRecuritment.EmployeeTests;

import com.BipSyncRecuritment.employees.Employee;
import com.BipSyncRecuritment.employees.EmployeeController;

import com.BipSyncRecuritment.employees.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EditingEmployeeDetailsTest {
    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    void testEditEmployeeDetails() {
        // Arrange
        Long recruitId = 1L;
        Employee existingEmployee = new Employee();
        existingEmployee.setRecruitId(recruitId);

        Employee updatedEmployee = new Employee();
        updatedEmployee.setFirstName("UpdatedFirstName");
        updatedEmployee.setLastName("UpdatedLastName");


        when(employeeService.getEmployeeById(recruitId)).thenReturn(existingEmployee);


        String result = employeeController.editEmployeeDetails(recruitId, updatedEmployee);


        verify(employeeService, times(1)).saveEmployee(existingEmployee);
        assertEquals("redirect:/employee/{recruitId}", result);
    }


}
