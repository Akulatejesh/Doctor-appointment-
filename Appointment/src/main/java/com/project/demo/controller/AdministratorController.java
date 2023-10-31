package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.project.demo.entities.Administrator;
import com.project.demo.entities.Doctor;
import com.project.demo.services.AdministratorService;
import com.project.demo.repository.DoctorRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/administrator/login")
    public String loginPage(Model model) {
        model.addAttribute("userType", "administrator");
        return "administrator-login";
    }

    @GetMapping("/administrator/dashboard")
    public String dashboardPage(Model model) {
        // Retrieve all doctors from the database
        List<Doctor> allDoctors = doctorRepository.findAll();

        // Add the list of all doctors to the model
        model.addAttribute("allDoctors", allDoctors);

        return "administrator-dashboard";
    }

    @PostMapping("/administrator/login")
    public String login(@RequestParam String user, @RequestParam String pass, HttpSession session) {
        Administrator administratorFromDB = administratorService.findAdministratorByUsernameAndPassword(user, pass);

        if (administratorFromDB != null) {
            session.setAttribute("loggedInAdministrator", administratorFromDB);
            return "redirect:/administrator/dashboard";
        } else {
            return "redirect:/aerror";
        }
    }

    @GetMapping("/aerror")
    public String administratorErrorPage() {
        return "aerror"; // Assuming you have a JSP file named "aerror.jsp" for administrator errors
    }
}
