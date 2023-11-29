package com.BipSyncRecuritment.newRecruitForm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class newRecruitFormController {
    @GetMapping("/newRecruitForm")
    public ModelAndView getNewRecruit(){
        ModelAndView modelAndView = new ModelAndView("newRecruitForm/newRecruitForm");
        return modelAndView;
    }
}
