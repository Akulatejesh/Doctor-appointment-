package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.demo.model.Doctor;
import com.project.demo.repositories.DoctorRepository;

public class DoctorService {
@Autowired
private DoctorRepository doctorRepository;

public void registerUser(String username, String password) {
    Doctor doctor = new Doctor();
    doctor.setUsername(username);
    doctor.setPassword(password);
    doctorRepository.save(doctor);
}

public Doctor findByUsernameAndPassword(String username,String password) {
    return doctorRepository.findByUsernameAndPassword(username,password);
}
}
