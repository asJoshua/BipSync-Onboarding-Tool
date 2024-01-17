package com.BipSyncRecuritment.landingPage;

import com.BipSyncRecuritment.employees.Employee;
import com.BipSyncRecuritment.employees.EmployeeService;
import com.BipSyncRecuritment.employees.Task;
import com.BipSyncRecuritment.employees.TaskService;
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
public class LandingPageController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public ModelAndView getHome(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        List<Task> overdueTasks = taskService.getOverdueTasks();
        List<Task> notOverdueTasks = taskService.getNotOverdueTasks();
        List<Employee> employees = employeeService.getAllEmployees();

        for (Task task : tasks) {
            String employeeNameForTask = taskService.getEmployeeNameForTask(task.getTaskId());
            model.addAttribute("employeeNameForTask", employeeNameForTask);
        }

        model.addAttribute("tasks", tasks);
        model.addAttribute("overdueTasks", overdueTasks);
        model.addAttribute("notOverdueTasks", notOverdueTasks);
        model.addAttribute("employees", employees);

        ModelAndView modelAndView = new ModelAndView("home/home");
        return modelAndView;
    }
}
