package com.BipSyncRecuritment.landingPage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LandingPageController {
    @GetMapping("/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("home/home");
        return modelAndView;
    }

    @GetMapping("/home/newRecruit")
    public ModelAndView addNewRecruit(){
        ModelAndView modelAndView = new ModelAndView("home/newRecruit");
        return modelAndView;
    }

    @PostMapping("/newRecruit")
    public ModelAndView addNewRecruit(NewRecruit newRecruit){

        NewRecruitService newRecruitService = NewRecruitService.getInstance();
        newRecruitService.addNewRecruit(newRecruit);

        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
}
