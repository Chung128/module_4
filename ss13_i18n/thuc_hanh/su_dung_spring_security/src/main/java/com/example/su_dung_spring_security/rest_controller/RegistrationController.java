package com.example.su_dung_spring_security.rest_controller;


import com.example.su_dung_spring_security.model.MyUser;
import com.example.su_dung_spring_security.repository.IMyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private IMyUserRepository myUserRepository;
    @Autowired
    public RegistrationController(IMyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register/user")
    public MyUser create(@RequestBody MyUser myUser){
        myUser.setPassword(passwordEncoder.encode(myUser.getPassword()));
        return myUserRepository.save(myUser);
    }
}
