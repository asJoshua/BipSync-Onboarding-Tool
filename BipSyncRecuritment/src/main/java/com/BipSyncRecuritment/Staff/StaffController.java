package com.BipSyncRecuritment.Staff;

import jakarta.validation.Valid;
import org.mariadb.jdbc.internal.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller // handles the request and then delegates the return to a template
public class StaffController {
    @Autowired
    private StaffRepository staffRepository;

    private StaffServiceImpl staffService;

    public StaffController(StaffServiceImpl aStaffService) {
        staffService = aStaffService;
    }

    private List<String> Staff = List.of("John smith", "Dillon jil", "Arnold Ben", "Thomas Picton");

    @GetMapping("/Staff")
    public ModelAndView getStaffList() {
        ModelAndView modelAndView = new ModelAndView("staff/staffList");
        List<staffInfo> staffInfo = staffService.getStaffInfo();
        modelAndView.addObject("StaffList", staffInfo);
        return modelAndView;
    }

    @GetMapping("/Staff/edit/{id}")
    public ModelAndView editStaff(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("staff/editStaff");
        staffInfo staff = staffService.getStaffInfo(id);

        modelAndView.addObject("staff", staff);
        return modelAndView;
    }
    @PostMapping("/Staff/edit/{id}")
    public ModelAndView updateStaff(@PathVariable Long id, @ModelAttribute("staffInfo") staffInfo staffInfo, BindingResult bindingResult)  {
        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return new ModelAndView("/staff/editStaff"); // Return to the edit page with error messages
        }
        staffRepository.updateStaffInfo(staffInfo);


        // Redirect to the staff list page or wherever appropriate
        return new ModelAndView("redirect:/Staff");
    }
    @GetMapping("/DeleteStaff/{id}")
    public ModelAndView deleteStaff(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("staff/staffList");
        staffRepository.deleteStaffMember(id);
        return new ModelAndView("redirect:/Staff");

    }
}
