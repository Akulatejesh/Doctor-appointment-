package com.project.demo.repositories;


 
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.demo.model.Doctor;
 

 
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {
	Doctor findByUsernameAndPassword(String username, String password);
}
 