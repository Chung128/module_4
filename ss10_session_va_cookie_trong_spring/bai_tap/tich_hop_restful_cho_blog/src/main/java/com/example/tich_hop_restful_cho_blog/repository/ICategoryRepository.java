package com.example.tich_hop_restful_cho_blog.repository;


import com.example.tich_hop_restful_cho_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer>{
}
