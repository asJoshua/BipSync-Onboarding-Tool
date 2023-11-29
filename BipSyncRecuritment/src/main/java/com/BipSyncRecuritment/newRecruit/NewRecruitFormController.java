package com.BipSyncRecuritment.newRecruit;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class NewRecruitFormController {
    private NewRecruitService newRecruitService;

    @GetMapping("/newRecruits")
    public ModelAndView newRecruits(){
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruits");
        List<NewRecruit> newRecruits= newRecruitService.getNewRecruits();
        modelAndView.addObject("newRecruits", newRecruits);
        return modelAndView;
    }

    @GetMapping("/newRecruit/add")
    public ModelAndView addNewRecruit(){
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruitForm");
        NewRecruitForm emptyNewRecruit = new NewRecruitForm();
        modelAndView.addObject("newRecruit", emptyNewRecruit);
        return modelAndView;
    }

    @PostMapping("/newRecruit/add")
    public ModelAndView addNewRecruit(@PathVariable(value = "id", required = false) Long id, @Valid @ModelAttribute("menuItem") NewRecruitForm newRecruit){
        NewRecruit newNewRecruit = new NewRecruit();
        newRecruitService.save(newNewRecruit);
        ModelAndView modelAndView = new ModelAndView("redirect:/menu");
        return modelAndView;
    }

}
