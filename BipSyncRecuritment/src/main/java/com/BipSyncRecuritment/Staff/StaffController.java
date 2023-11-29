package com.BipSyncRecuritment.Staff;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller // handles the request and then delegates the return to a template
public class StaffController {
    private List<String> Staff = List.of("John smith","Dillon jil","Arnold Ben", "Thomas Picton");
    @GetMapping("/Staff")
    public ModelAndView getStaffList() {
        ModelAndView modelAndView = new ModelAndView("staff/staffList");
        StaffService staffService =StaffService.getInstance();
        List<staffInfo> staffInfo = staffService.getStaffList();
//        List<String> staffName =
//        staffName = staffInfo.stream().map(staffInfo::getName).toList();
        modelAndView.addObject("StaffList",staffInfo);
        return modelAndView;
    }
}
