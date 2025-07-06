package com.example.su_dung_spring_security.repository;

import com.example.su_dung_spring_security.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMyUserRepository extends JpaRepository<MyUser,Long> {
    Optional<MyUser> findByUsername(String username);
}
