package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
import com.project.demo.entities.Patient;
 
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUsername(String username);
}
