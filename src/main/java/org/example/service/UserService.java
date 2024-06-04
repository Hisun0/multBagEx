package org.example.service;

import net.datafaker.Faker;
import org.example.model.EmailAddress;
import org.example.model.MobileNumber;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.Util.createALotOfUsers;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUsers() {
        var users = createALotOfUsers();
        userRepository.saveAll(users);
    }

    public List<User> findByFullNameContaining(String fullName) {
        return userRepository.findByFullNameContaining(fullName);
    }
}
