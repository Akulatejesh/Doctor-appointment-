package com.project.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.demo.model.Appointment;
import com.project.demo.model.Doctor;
import com.project.demo.model.Patient;
import com.project.demo.services.AppointmentService;
import com.project.demo.services.DoctorService;
import com.project.demo.services.PatientService;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService; // Autowire PatientService

    @Autowired
    private DoctorService doctorService; // Autowire DoctorService

    @GetMapping("/list")
    public String listAppointments(Model model) {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointments);
        return "appointment-list"; // Create a corresponding JSP view.
    }

    @GetMapping("/schedule")
    public String showAppointmentScheduling(Model model) {
        List<Patient> patients = patientService.getAllPatients();
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("patients", patients);
        model.addAttribute("doctors", doctors);
        model.addAttribute("appointment", new Appointment());
        return "appointment-scheduling"; // Create a corresponding JSP view for scheduling.
    }

    @PostMapping("/schedule")
    public String scheduleAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments/list";
    }

    // Define other appointment-related request handlers here.
}
