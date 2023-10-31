package com.project.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.model.Doctor;
import com.project.demo.services.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/list")
    public String listDoctors(Model model) {
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors", doctors);
        return "doctor-list"; // Create a corresponding JSP view to display the list of doctors.
    }

    @GetMapping("/manage")
    public String showDoctorManagement(Model model) {
        // Add logic to display the doctor management interface.
        List<Doctor> doctors = doctorService.getAllDoctors(); // Load the list of doctors
        model.addAttribute("doctors", doctors); // Add the list of doctors to the model
        return "doctor-management"; // Create a corresponding JSP view for doctor management.
    }

    @GetMapping("/register")
    public String showDoctorRegistrationForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctor-registration"; // Create a corresponding JSP view for doctor registration.
    }

    @PostMapping("/register")
    public String registerDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors/list";
    }

    // Add more methods for updating, deleting, or other doctor-related functionalities here.
}
