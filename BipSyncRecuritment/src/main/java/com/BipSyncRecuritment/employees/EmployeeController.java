package com.BipSyncRecuritment.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TaskService taskService;

//Mapping to display all current employees on the page
    @GetMapping("/employee")
    public ModelAndView getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        ModelAndView modelAndView = new ModelAndView("employees/employee");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/employee/{recruitId}")
    public String getEmployeeTasks(@PathVariable Long recruitId, Model model) {
        Employee employee = employeeService.getEmployeeById(recruitId);
        model.addAttribute("employee", employee);
        return "employees/employee-tasks";
    }

    @PostMapping("/employee/{recruitId}/add-task")
    public String addTaskForEmployee(
            @PathVariable Long recruitId,
            @RequestParam String taskName,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate taskDueDate,
            @RequestParam String taskResponsibility

    ) {
        if (taskName != null && !taskName.isEmpty()) {
            Employee employee = employeeService.getEmployeeById(recruitId);
            Task newTask = new Task();
            newTask.setTaskName(taskName);
            newTask.setTaskDueDate(taskDueDate);
            newTask.setTaskResponsibility(taskResponsibility);



            taskService.saveTask(newTask);


            employee.getTasks().add(newTask);
            employeeService.saveEmployee(employee);

            return "redirect:/employee/{recruitId}";
        } else {
            // Handle the case where subjectName is empty
            return "redirect:/employee/recruitId}?error=empty_task";
        }
    }


}
