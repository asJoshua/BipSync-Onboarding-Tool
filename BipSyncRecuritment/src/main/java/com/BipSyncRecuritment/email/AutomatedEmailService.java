package com.BipSyncRecuritment.email;

import com.BipSyncRecuritment.employees.Employee;
import com.BipSyncRecuritment.employees.EmployeeService;
import com.BipSyncRecuritment.employees.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutomatedEmailService {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmailService emailService;


//Email reminder to send a day before its due

    @Scheduled(cron = "0 48 09 * * *")
    public void sendEmailIsDueInOneDay() {
        LocalDate aDayBefore = LocalDate.now().plusDays(1);

        List<Employee> employees = employeeService.getAllEmployees();

        for (Employee employee : employees) {
            employee.getTasks().size();

            for (Task task : employee.getTasks()) {
                if (task.getTaskDueDate() != null && task.getTaskDueDate().equals(aDayBefore)) {
                    String to = task.getTaskDepartmentEmail();
                    String subjectText = "Task Reminder (Due in One Day): " + task.getTaskName();
                    String body = "Dear " + task.getTaskResponsibility() + "\n\nYou have a task to complete : " + task.getTaskName() + " required for employee: " + employee.getFirstName() + " " + employee.getLastName() + "\n\n Which is due in One day: " + task.getTaskDueDate();

                    emailService.sendEmail(to, subjectText, body);
                }
            }
        }
    }
}
