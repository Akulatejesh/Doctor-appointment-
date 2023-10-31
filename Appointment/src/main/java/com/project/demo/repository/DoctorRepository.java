package com.project.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.demo.entities.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByUsernameAndPassword(String username,String password);
}