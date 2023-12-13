package com.BipSyncRecuritment.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TaskRepository taskRepository;
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long recruitId) {
        employeeRepository.deleteById(recruitId);
    }
    public List<Task> getCompletedTasks(Long recruitId) {
        Employee employee = employeeRepository.findById(recruitId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return taskRepository.findAllById(employee.getCompletedTasks());
    }


}
