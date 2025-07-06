package com.example.tich_hop_security_cho_ung_dung_blog.repository;

import com.example.tich_hop_security_cho_ung_dung_blog.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMyUserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByUsername(String username);
}
