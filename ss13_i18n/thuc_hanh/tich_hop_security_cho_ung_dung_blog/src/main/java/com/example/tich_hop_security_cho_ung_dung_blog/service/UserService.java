package com.example.tich_hop_security_cho_ung_dung_blog.service;

import com.example.tich_hop_security_cho_ung_dung_blog.model.MyUser;
import com.example.tich_hop_security_cho_ung_dung_blog.repository.IMyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private IMyUserRepository userRepository;

    @Autowired
    public UserService(IMyUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<MyUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<MyUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
