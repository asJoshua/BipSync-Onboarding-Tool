package com.BipSyncRecuritment.employees;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/employee/{recruitId}/details")
    public ModelAndView getEmployeeDetails(@PathVariable Long recruitId, Model model) {
        Employee employees = employeeService.getEmployeeById(recruitId);
        ModelAndView modelAndView = new ModelAndView("employees/employee-details");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/employee/{recruitId}")
    public String getEmployeeTasks(@PathVariable Long recruitId, Model model) {
        Employee employee = employeeService.getEmployeeById(recruitId);
        model.addAttribute("employee", employee);
        return "employees/employee-tasks";
    }

    @GetMapping("/employee/{recruitId}/edit")
    public String getEmployeeEditForm(@PathVariable Long recruitId, Model model) {
        Employee employee = employeeService.getEmployeeById(recruitId);
        model.addAttribute("employee", employee);
        return "employees/employee-details-edit";

    }

    @PostMapping("/employee/{recruitId}/edit")
    public String editEmployeeDetails(@PathVariable Long recruitId, @Valid @ModelAttribute Employee updatedEmployee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "employees/employee-details-edit";
        }
        Employee currentEmployee = employeeService.getEmployeeById(recruitId);


        currentEmployee.setFirstName(updatedEmployee.getFirstName());
        currentEmployee.setLastName(updatedEmployee.getLastName());
        currentEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
        currentEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        currentEmployee.setPosition(updatedEmployee.getPosition());
        currentEmployee.setEmail(updatedEmployee.getEmail());
        currentEmployee.setPassportNumber(updatedEmployee.getPassportNumber());
        currentEmployee.setNationalInsuranceNumber(updatedEmployee.getNationalInsuranceNumber());
        currentEmployee.setDateOfHire(updatedEmployee.getDateOfHire());
        currentEmployee.setEmergencyContactName(updatedEmployee.getEmergencyContactName());
        currentEmployee.setEmergencyContactPhoneNumber(updatedEmployee.getEmergencyContactPhoneNumber());


        employeeService.saveEmployee(currentEmployee);

        return "redirect:/employee/{recruitId}";
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
        }
            return "redirect:/employee/{recruitId}";

        }


    @PostMapping("/employee/{recruitId}/remove-task/{taskId}")
    public String removeTask(
            @PathVariable Long recruitId,
            @PathVariable Long taskId
    ) {
        Employee employee = employeeService.getEmployeeById(recruitId);
        Optional<Task> taskToRemove = employee.getTasks().stream()
                .filter(task -> task.getTaskId().equals(taskId))
                .findFirst();

        if (taskToRemove.isPresent()) {
            Task removedTask = taskToRemove.get();
            employee.completeTask(removedTask.getTaskId());

            employee.removeTasks(taskId);
            employeeService.saveEmployee(employee);



        }
        return "redirect:/employee/{recruitId}";
    }



    @GetMapping("/employee/{recruitId}/completed-tasks")
    public String viewCompletedTasks(@PathVariable Long recruitId, Model model) {
        List<Task> completedTasks = employeeService.getCompletedTasks(recruitId);
        model.addAttribute("completedTasks", completedTasks);
        return "employees/employee-completed-tasks";


    }
    @GetMapping("RemoveEmployee/{recruitId}")
    public String deleteEmployee(@PathVariable Long recruitId, RedirectAttributes redirectAttributes) {
        employeeService.deleteEmployee(recruitId);

        // Add a flash attribute to pass data to the redirected page
        redirectAttributes.addFlashAttribute("message", "Employee removed successfully");

        return "redirect:/employee";
    }

}
