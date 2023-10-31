package com.project.demo.controller;
 
import com.project.demo.entities.PatientDetails;
import com.project.demo.entities.Receptionist;
import com.project.demo.repository.PatientDetailsRepository;
import com.project.demo.services.ReceptionistService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.demo.entities.Doctor;
import com.project.demo.entities.Patient;
import com.project.demo.repository.DoctorRepository;
 
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
 
@Controller
public class ReceptionistController {
    @Autowired
    private ReceptionistService receptionistService;
 
    @Autowired
    private PatientDetailsRepository patientDetailsRepository;
 
    @Autowired
    private DoctorRepository doctorRepository; // Inject DoctorRepository
 
    @GetMapping("/receptionist/login")
    public String loginPage() {
        return "receptionist-login"; // Assuming you have a JSP file named "receptionist-login.jsp"
    }
 
    @GetMapping("/receptionist/dashboard")
    public String displayDashboard(Model model) {
        // Get the list of doctors for the dropdown
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
 
        return "receptionist-dashboard";
    }
 
    @PostMapping("/receptionist/login")
    public String login(@RequestParam String user, @RequestParam String pass, HttpSession session) {
        Receptionist receptionistFromDB = receptionistService.findReceptionistByUsernameAndPassword(user, pass);
 
        if (receptionistFromDB != null) {
            // Authentication successful
            session.setAttribute("loggedInReceptionist", receptionistFromDB);
            return "redirect:/receptionist/dashboard"; // Redirect to the receptionist's dashboard page
        } else {
            // Authentication failed
            return "redirect:/rerror"; // Receptionist login page with an error message
        }
    }
 
    @GetMapping("/rerror")
    public String receptionistErrorPage() {
        return "rerror"; // Assuming you have a JSP file named "rerror.jsp" for receptionist errors
    }
 
    @PostMapping("/receptionist/patient-details")
    public String createPatient(
        @RequestParam String patientName,
        @RequestParam String patientInfo,
        @RequestParam int age,
        @RequestParam String address,
        @RequestParam String phoneNumber,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate appointmentDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime appointmentTime,
        @RequestParam Long doctorId,
        HttpSession session) {
 
        // Retrieve the logged-in patient
        Patient loggedInPatient = (Patient) session.getAttribute("loggedInPatient");
 
        if (loggedInPatient != null) {
            // Create a new PatientDetails
            PatientDetails patientDetails = new PatientDetails();
 
            // Set the associated patient
            patientDetails.setPatient(loggedInPatient);
 
            // Set other details for the patient
            patientDetails.setPatientName(patientName);
            patientDetails.setPatientInfo(patientInfo);
            patientDetails.setAge(age);
            patientDetails.setAddress(address);
            patientDetails.setPhoneNumber(phoneNumber);
            patientDetails.setAppointmentDate(appointmentDate);
            patientDetails.setAppointmentTime(appointmentTime);
 
            // Retrieve the doctor by doctorId and set it for the patient details
            Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
            if (doctor != null) {
                patientDetails.setDoctor(doctor);
            }
 
            // Save the patient details to the database
            patientDetailsRepository.save(patientDetails);
 
            // Redirect to an appropriate view or page
            return "redirect:/receptionist/dashboard"; // Redirect to the receptionist's dashboard
        } else {
            // Handle the case where the patient is not logged in
            return "redirect:/patientlogin"; // Redirect to the patient login page
        }
    }
 
}