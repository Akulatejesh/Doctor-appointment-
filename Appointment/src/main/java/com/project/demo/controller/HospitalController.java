package com.project.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalController {

    @GetMapping("/staff")
    public String homePage() {
        return "staff";
    }
}
