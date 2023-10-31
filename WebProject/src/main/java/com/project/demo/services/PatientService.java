package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.demo.model.Patient;
import com.project.demo.repositories.PatientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        Iterable<Patient> patientIterable = patientRepository.findAll();
        List<Patient> patients = new ArrayList<>();
        patientIterable.forEach(patients::add);
        return patients;
    }

    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
