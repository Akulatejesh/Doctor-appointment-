package com.project.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.demo.entities.Administrator;
import com.project.demo.repository.AdministratorRepository;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    public void registerAdministrator(String username, String password) {
        Administrator administrator = new Administrator();
        administrator.setUsername(username);
        administrator.setPassword(password);
        administratorRepository.save(administrator);
    }

    public Administrator findAdministratorByUsernameAndPassword(String username, String password) {
        return administratorRepository.findByUsernameAndPassword(username, password);
    }
}
