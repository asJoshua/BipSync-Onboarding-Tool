package com.BipSyncRecuritment.Staff;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class StaffApiController {
    private List<String> Staff = List.of("John smith","Dillon jil", "Jim til", "Arnold Ben", "Thomas Picoton"); // Employee data
    @GetMapping("/staff")
    public List<String> Staff(@RequestParam(name="includes", required = false) //Includes parameter allows me to type a specific name or word in the url and it will show it
                                  Optional<String> includes){
        if (includes.isPresent()) {
        return Staff
                .stream()
                .filter(item -> item.contains(includes.get()))
                .collect(Collectors.toList());
        } else {
            return Staff;
        }
    }
    @GetMapping("Staff/{index}")
    public String getStaffList(@PathVariable("index") Integer index) { // return a specific employee based on their index
        return Staff.get(index);

    }
    }






