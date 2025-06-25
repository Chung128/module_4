package com.example.nang_cap_my_blog.repository;



import com.example.nang_cap_my_blog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer>{
}
