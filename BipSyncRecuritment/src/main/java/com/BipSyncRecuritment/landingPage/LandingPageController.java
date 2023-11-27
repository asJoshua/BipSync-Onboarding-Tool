package com.BipSyncRecuritment.landingPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@RestController
public class LandingPageController {
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/home")
    public ModelAndView dash(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail" , userDetails);
        return modelAndView;
    }

    @GetMapping("/home/newRecruit")
    public ModelAndView addNewRecruit(){
        ModelAndView modelAndView = new ModelAndView("home/newRecruit");
        return modelAndView;
    }

    @PostMapping("/newRecruit")
    public ModelAndView addNewRecruit(NewRecruit newRecruit){
        System.out.print(newRecruit);

        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }
}
