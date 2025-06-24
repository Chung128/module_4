package com.example.demo.repository;

import com.example.demo.model.MyBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<MyBlog,Integer> {
}
