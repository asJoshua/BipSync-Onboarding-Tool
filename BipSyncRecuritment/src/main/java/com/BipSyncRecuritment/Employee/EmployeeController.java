package com.BipSyncRecuritment.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller // handles the request and then delegates the return to a template
public class EmployeeController {
    private List<String> employee = List.of("John smith","Dillon jil","Arnold Ben", "Thomas Picoton");
    @GetMapping("/employee")
    public ModelAndView getEmployee() {
        ModelAndView modelAndView = new ModelAndView("employee/employeeList");
        modelAndView.addObject("employeeList", employee);
        return modelAndView;
    }
}
