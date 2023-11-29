package com.BipSyncRecuritment.landingPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.security.Principal;
@RestController
public class LandingPageController {
    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/home")
    public ModelAndView getHome(Model model, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userdetail" , userDetails);
        return modelAndView;
    }
}
