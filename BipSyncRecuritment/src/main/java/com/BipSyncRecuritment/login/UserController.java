package com.BipSyncRecuritment.login;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginDetailsService userLoginDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;



    @Autowired
    ResetPasswordTokenRepository tokenRepository;
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

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "login/forgotPassword";
    }


    @PostMapping("/forgotPassword")
    public String forgotPasswordProcess(@RequestParam("email") String userEmail) {
        String output = "";
        User currentUser = userRepository.findByUserEmail(userEmail);
        if (currentUser != null) {
            output = userLoginDetailsService.sendResetPasswordEmail(currentUser);
        }
        if (output.equals("success")) {
            return "redirect:/forgotPassword?success";
        }
        return "redirect:/forgotPassword?error";
    }
    @GetMapping("/resetPassword/{token}")
    public String resetPasswordForm(@PathVariable String token, Model model) {
        ResetPasswordToken reset = tokenRepository.findByToken(token);
        if (reset != null && userLoginDetailsService.hasExipred(reset.getExpiryDateTime())) {
            model.addAttribute("user", reset.getUser());
            return "login/resetPassword";
        }
        return "redirect:/forgotPassword?error";
    }

    @PostMapping("/resetPassword")
    public String passwordResetProcess(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @RequestParam("confirm-password") String confirmPassword) {
        if (!user.getPassword().equals(confirmPassword)) {
            bindingResult.rejectValue("password", "error.user", "Passwords do not match");
        }
        if (bindingResult.hasErrors()) {
            return "login/resetPassword";
        }
        User currentUser = userRepository.findByUserEmail(user.getUserEmail());
        System.out.println("currentUser: " + currentUser);
        if (currentUser != null) {
            currentUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(currentUser);
        }
        return "redirect:/login";
    }


    @GetMapping("/registerStaff")
    public ModelAndView registerStaffUser(Model model) {
        ModelAndView modelAndView = new ModelAndView("login/registerStaff");
        model.addAttribute("user", new User());
        return modelAndView;
    }

    @PostMapping("/registerStaff")
    public ModelAndView registerUser(@ModelAttribute("user") User user, @RequestParam String username, @RequestParam String userEmail, @RequestParam String userFirstName, @RequestParam String userLastName, @RequestParam String password) {
        Set<String> roles = new HashSet<>(Arrays.asList("STAFF"));
        userLoginDetailsService.registerStaff(username, userEmail,userFirstName ,userLastName,password, roles);
        ModelAndView modelAndView = new ModelAndView("login/login");
        return  modelAndView;
    }
}




