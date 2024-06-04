package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.model.User;
import org.example.repository.CriteriaUserRepository;
import org.example.service.CriteriaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CriteriaUserController {
    @Autowired
    private CriteriaUserService userService;

    @Autowired
    private CriteriaUserRepository userRepository;

    @GetMapping("/criteria/users")
    public List<User> showAll() {
        return userRepository.findAll();
    }

    @GetMapping("/criteria/users/name")
    public List<User> showByName(@RequestParam String fullName) {
        return userService.findByFullNameContaining(fullName);
    }
}
