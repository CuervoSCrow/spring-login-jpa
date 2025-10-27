package com.crowcode.spring_login_jpa.service;

import com.crowcode.spring_login_jpa.model.User;
import com.crowcode.spring_login_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public User save(User user){
        return userRepository.save(user);
    }
}
