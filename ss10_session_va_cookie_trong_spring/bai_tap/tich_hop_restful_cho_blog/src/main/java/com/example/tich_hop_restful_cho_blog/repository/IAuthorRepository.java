package com.example.tich_hop_restful_cho_blog.repository;


import com.example.tich_hop_restful_cho_blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author,Integer> {
}
