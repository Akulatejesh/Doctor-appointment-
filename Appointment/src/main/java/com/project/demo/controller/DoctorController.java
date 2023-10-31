package com.project.demo.controller;

import com.project.demo.entities.Doctor;
import com.project.demo.entities.PatientDetails;
import com.project.demo.services.DoctorService;
import com.project.demo.repository.DoctorRepository;
import com.project.demo.repository.PatientDetailsRepository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

@Controller
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientDetailsRepository patientDetailsRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Assuming you have a JSP file named "login.jsp" for doctor login
    }

    @GetMapping("/doctor/dashboard")
    public String displayDoctorDashboard(Model model, HttpSession session) {
        Doctor loggedInDoctor = (Doctor) session.getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            // Get patient details for the logged-in doctor
            List<PatientDetails> patients = patientDetailsRepository.findByDoctor(loggedInDoctor);
            model.addAttribute("patients", patients);
            model.addAttribute("loggedInDoctor", loggedInDoctor);
            return "dashboard"; // Assuming your JSP file is named "DoctorDashboard.jsp"
        } else {
            return "redirect:/login"; // Redirect to the login page if not logged in
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String pass, HttpSession session) {
        Doctor doctorFromDB = doctorRepository.findByUsernameAndPassword(user, pass);

        if (doctorFromDB != null) {
            // Authentication successful
            session.setAttribute("loggedInDoctor", doctorFromDB);
            return "redirect:/doctor/dashboard"; // Redirect to the doctor's dashboard page
        } else {
            // Authentication failed
            return "redirect:/error"; // Doctor login page with an error message
        }
    }

    @PostMapping("/doctor/request-leave")
    public String requestLeave(@RequestParam("leaveStartDate") Date leaveStartDate, @RequestParam("leaveEndDate") Date leaveEndDate, HttpSession session) {
        Doctor loggedInDoctor = (Doctor) session.getAttribute("loggedInDoctor");
        if (loggedInDoctor != null) {
            // Update the doctor's leave start date and end date
            loggedInDoctor.setLeaveStartDate(leaveStartDate);
            loggedInDoctor.setLeaveEndDate(leaveEndDate);

            // Save the updated doctor entity to the database
            doctorRepository.save(loggedInDoctor);

            // Optionally, you can set a flag in the doctor entity to indicate leave status
            loggedInDoctor.setLeaveRequested(true);
            doctorRepository.save(loggedInDoctor);
        }
        return "redirect:/doctor/dashboard";
    }

    // Add other methods as needed
}
