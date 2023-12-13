package com.BipSyncRecuritment.newRecruit;

import com.BipSyncRecuritment.employees.Employee;
import com.BipSyncRecuritment.employees.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewRecruitFormController {
    private NewRecruitService newRecruitService;
    @Autowired
    private EmployeeService employeeService;

    public NewRecruitFormController(NewRecruitService aNewRecruitService) {
        this.newRecruitService = aNewRecruitService;
    }

    @GetMapping("/newRecruits")
    public ModelAndView newRecruits(){
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruits");
        List<Employee> employees = employeeService.getAllEmployees();
        modelAndView.addObject("employees", employees);

        List<NewRecruit> newRecruits= newRecruitService.getNewRecruits();
        modelAndView.addObject("newRecruits", newRecruits);
        return modelAndView;
    }

    @GetMapping("/newRecruit/{recruitId}")
    public ModelAndView getNewRecruit(@PathVariable Long recruitId) {
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruitDetails");
        NewRecruit newRecruit = newRecruitService.getNewRecruit(recruitId);
        modelAndView.addObject("newRecruit", newRecruit);
        return modelAndView;
    }

    @GetMapping("/newRecruit/add")
    public ModelAndView addNewRecruit(){
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruitForm");
        NewRecruitForm emptyNewRecruit = new NewRecruitForm();
        modelAndView.addObject("newRecruit", emptyNewRecruit);
        return modelAndView;
    }

    @PostMapping("/newRecruit/add")
    public ModelAndView addNewRecruit(@PathVariable(value = "recruitId", required = false) Long recruitId, @Valid @ModelAttribute("newRecruit") NewRecruitForm newRecruit){
        NewRecruit newNewRecruit = new NewRecruit(newRecruit.getRecruitId(), newRecruit.getFirstName(), newRecruit.getLastName(), newRecruit.getDateOfBirth(), newRecruit.getPhoneNumber(), newRecruit.getPassportNumber(), newRecruit.getNationalInsuranceNumber(), newRecruit.getEmail(), newRecruit.getPosition(), newRecruit.getDateOfHire(), newRecruit.getEmergencyContactName(), newRecruit.getEmergencyContactPhoneNumber());
        newRecruitService.save(newNewRecruit);
        ModelAndView modelAndView = new ModelAndView("redirect:/newRecruits");
        return modelAndView;
    }

}
