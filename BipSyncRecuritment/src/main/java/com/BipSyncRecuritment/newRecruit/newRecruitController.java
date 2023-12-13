package com.BipSyncRecuritment.newRecruit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class newRecruitController {
    @GetMapping("/newRecruitForm")
    public ModelAndView addNewRecruit(){
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruitForm");
        return modelAndView;
    }
}
