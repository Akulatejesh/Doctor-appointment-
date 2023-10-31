package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Doctor;
import com.project.demo.repositories.DoctorRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        Iterable<Doctor> doctorIterable = doctorRepository.findAll();
        List<Doctor> doctors = new ArrayList<>();
        doctorIterable.forEach(doctors::add);
        return doctors;
    }

    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId).orElse(null);
    }

    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
}
