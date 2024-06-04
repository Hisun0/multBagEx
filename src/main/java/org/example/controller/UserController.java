package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users/create")
    public void create() {
        service.addUsers();
    }

    @GetMapping("/users/all")
    public List<User> showAll() {
        return userRepository.findAll();
    }

    @GetMapping("/users")
    public List<User> showAllByName(@RequestParam String fullName) {
        return service.findByFullNameContaining(fullName);
    }

    @GetMapping("/users/count")
    public String showCount() {
        return userRepository.count() + "users in repository";
    }

    @GetMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }
}
