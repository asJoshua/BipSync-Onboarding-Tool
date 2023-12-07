package com.BipSyncRecuritment.newRecruit;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewRecruitFormController {
    private NewRecruitService newRecruitService;

    public NewRecruitFormController(NewRecruitService aNewRecruitService) {
        this.newRecruitService = aNewRecruitService;
    }
    @GetMapping("/newRecruits")
    public ModelAndView newRecruits(){
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruits");
        List<NewRecruit> newRecruits= newRecruitService.getNewRecruits();
        modelAndView.addObject("newRecruits", newRecruits);
        return modelAndView;
    }

    @GetMapping("/newRecruit/{id}")
    public ModelAndView getNewRecruit(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("newRecruit/newRecruitDetails");
        NewRecruit newRecruit = newRecruitService.getNewRecruit(id);
        modelAndView.addObject("newRecruit", newRecruit);
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
        NewRecruit newNewRecruit = new NewRecruit(newRecruit.getId(), newRecruit.getFirstName(), newRecruit.getLastName());
        newRecruitService.save(newNewRecruit);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

}
