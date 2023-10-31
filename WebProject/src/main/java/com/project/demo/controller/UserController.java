package com.project.demo.controller;

import com.project.demo.model.User;
import com.project.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String showUserAdministration(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-administration"; // Create a corresponding JSP view.
    }

    // Add more user-related request handlers here as needed.
}
