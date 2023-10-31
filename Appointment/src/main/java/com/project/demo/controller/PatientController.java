package com.project.demo.controller;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
 
import com.project.demo.entities.Doctor;
import com.project.demo.entities.Patient;
import com.project.demo.entities.PatientDetails;
import com.project.demo.repository.DoctorRepository;
import com.project.demo.services.PatientService;
import com.project.demo.services.DoctorService;
import com.project.demo.services.PatientDetailsService;
 
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
 
@Controller
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientDetailsService patientDetailsService;
 
    @GetMapping("/receptionist-dashboard")
    public String welcomePatient(Model model) {
    	 List<Doctor> doctors = doctorRepository.findAll();
         model.addAttribute("doctors", doctors);
 
        return "receptionist-dashboard";
    }
 
    
 
    @GetMapping("/patientregistration")
    public String patientRegistrationPage() {
        return "patientregistration";
    }
 
    @PostMapping("/patientregistration")
    public String registerPatient(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpSession session) {
        Patient patient = patientService.registerPatient(username, password);
 
        if (patient == null) {
            // Handle the case where registration failed (e.g., username already in use)
            request.setAttribute("error", "Invalid registration. Please try again.");
            return "redirect:/patientregistration"; // Redirect back to registration page with an error message
        } else {
        	session.setAttribute("loggedInPatient",patient);
            // Redirect to the patient's dashboard or another page
            return "redirect:/receptionist-dashboard";
        }
    }
 
    @GetMapping("/patientlogin")
    public String patientLoginPage() {
        return "patientlogin";
    }
 
    @PostMapping("/patientlogin")
    public String loginPatient(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpSession session) {
        Patient patient = patientService.loginPatient(username, password);
 
        if (patient == null) {
            // Handle the case where login failed (e.g., invalid credentials)
            request.setAttribute("error", "Invalid login. Please try again.");
            return "redirect:/patientlogin"; // Redirect back to login page with an error message
        } else {
            session.setAttribute("loggInPatient", patient);
            // Redirect to the patient's dashboard or another page
            return "redirect:/patientdetailsdisplay";
        }
    }
    @GetMapping("/patientdetailsdisplay")
    public String displayPatientDetails(Model model, HttpSession session) {
        // Retrieve the logged-in patient
        Patient loggedInPatient = (Patient) session.getAttribute("loggInPatient");
        if (loggedInPatient != null) {
            // Fetch the patient's details based on their ID
            List<PatientDetails> patientDetails = patientDetailsService.findPatientDetailsByPatientId(loggedInPatient.getId());
            System.out.println(loggedInPatient.getId());
 
            if (!patientDetails.isEmpty()) {
            	for (PatientDetails detail : patientDetails) {
                    System.out.println("Patient Detail: " + detail);
                }
                model.addAttribute("patientDetails", patientDetails);
                return "patientdetailsdisplay"; // Assuming you have a JSP file named "patientdetailsdisplay.jsp"
            } else {
                // Handle the case where patient details are not found
                return "redirect:/rerror"; // Redirect to an error page
            }
        } else {
            // Handle the case where the patient is not logged in
            return "redirect:/patientlogin"; // Redirect to the patient login page
        }
    }
 
}