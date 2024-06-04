package org.example.service;

import org.example.model.User;
import org.example.repository.CriteriaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.Util.createALotOfUsers;

@Service
public class CriteriaUserService {
    @Autowired
    private CriteriaUserRepository userRepository;

    public List<User> findByFullNameContaining(String fullName) {
        return userRepository.findByFullNameContaining(fullName);
    }
}
