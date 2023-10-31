package com.project.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.demo.entities.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByUsernameAndPassword(String username, String password);
}
