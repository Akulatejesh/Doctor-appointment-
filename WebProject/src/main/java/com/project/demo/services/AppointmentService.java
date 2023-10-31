package com.project.demo.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Appointment;
import com.project.demo.repositories.AppointmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        Iterable<Appointment> iterableAppointments = appointmentRepository.findAll();
        List<Appointment> appointments = new ArrayList<>();
        iterableAppointments.forEach(appointments::add);
        return appointments;
    }

    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    // Add other methods related to appointment services here.
}
