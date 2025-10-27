package com.crowcode.spring_login_jpa.controller;

import com.crowcode.spring_login_jpa.model.User;
import com.crowcode.spring_login_jpa.service.UserService;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.save(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userService.findByUsername(user.getUsername())
                .filter(u->u.getPassword().equals(user.getPassword()))
                .map(u -> "Login exitoso")
                .orElse("Credenciales Incorrectas");
    }
}
