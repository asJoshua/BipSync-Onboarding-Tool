package com.BipSyncRecuritment.Employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class EmployeeApiController {
    private List<String> employees = List.of("John smith","Dillon jil", "Jim til", "Arnold Ben", "Thomas Picoton"); // Employee data
    @GetMapping("/employee")
    public List<String> employees(@RequestParam(name="includes", required = false) //Includes parameter allows me to type a specific name or word in the url and it will show it
                                  Optional<String> includes){
        if (includes.isPresent()) {
        return employees
                .stream()
                .filter(item -> item.contains(includes.get()))
                .collect(Collectors.toList());
        } else {
            return employees;
        }
    }
    @GetMapping("employee/{index}")
    public String getMenuItem(@PathVariable("index") Integer index) { // return a specific employee based on their index
        return employees.get(index);

    }
    }






