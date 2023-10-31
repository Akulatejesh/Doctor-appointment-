package com.project.demo.services;

import com.project.demo.model.User;
import com.project.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        Iterable<User> userIterable = userRepository.findAll();
        List<User> users = new ArrayList<>();
        userIterable.forEach(users::add);
        return users;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    // Add more user-related service methods here as needed.
}
