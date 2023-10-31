package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.demo.entities.Receptionist;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Long> {
    Receptionist findByUsernameAndPassword(String username, String password);
}
