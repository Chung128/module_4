package com.example.tich_hop_security_cho_ung_dung_blog.service;

import com.example.tich_hop_security_cho_ung_dung_blog.model.MyUser;

import java.util.List;
import java.util.Optional;

public interface IUserService  {
    List<MyUser> findAll();
    Optional<MyUser> findByUsername(String username);
}
