package com.BipSyncRecuritment.landingPage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LandingPageController {
    private NewRecruitService newRecruitService;
    @GetMapping("/home")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("home/home");
        return modelAndView;
    }

    @GetMapping("/home/newRecruit")
    public ModelAndView addNewRecruit(){
        ModelAndView modelAndView = new ModelAndView("home/newRecruit");
        List<NewRecruit> newRecruit = newRecruitService.getNewRecruits();
        modelAndView.addObject("newRecruit", newRecruit);
        return modelAndView;
    }

    @PostMapping("/home/newRecruit")
    public ModelAndView addNewRecruit(NewRecruit newRecruit){

        NewRecruitService newRecruitService = NewRecruitService.getInstance();
        newRecruitService.addNewRecruit(newRecruit);

        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        modelAndView.addObject("newRecruit", newRecruit);
        return modelAndView;
    }
}
