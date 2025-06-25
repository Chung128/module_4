package com.example.nang_cap_my_blog.repository;


import com.example.nang_cap_my_blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author,Integer> {
}
