package com.BipSyncRecuritment.landingPage;

import com.BipSyncRecuritment.employees.Employee;
import com.BipSyncRecuritment.employees.EmployeeService;
import com.BipSyncRecuritment.employees.Task;
import com.BipSyncRecuritment.employees.TaskService;
import com.structurizr.annotation.UsedByPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.security.Principal;
@RestController
@UsedByPerson(name = "Admin", description = "Navigate to other pages", technology = "http(s)")
public class LandingPageController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/home")
    public ModelAndView getHome(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);

        ModelAndView modelAndView = new ModelAndView("home/home");
        return modelAndView;
    }
}
