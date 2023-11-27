package com.BipSyncRecuritment.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//Mapping to display all current employees on the page
    @GetMapping("/employee")
    public ModelAndView getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ModelAndView modelAndView = new ModelAndView("employees/employee");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }


}
