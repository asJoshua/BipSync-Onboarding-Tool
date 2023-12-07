package com.BipSyncRecuritment.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    private UserDetailsService userDetailsService;

    private UserService userService;
    public UserController(UserService userService) {

        this.userService = userService;

    }

    //mapping for the login page
    @GetMapping("/login")
    public ModelAndView login(Model model) {
        ModelAndView modelAndView = new ModelAndView("login/login");
        model.addAttribute("user", new User());
        return modelAndView;
    }

}
