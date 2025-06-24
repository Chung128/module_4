package com.example.demo.service;

import com.example.demo.model.MyBlog;

import java.util.List;

public interface IBlogService {
    List<MyBlog> findAll();

    void save(MyBlog blog);

    MyBlog findById(int id);

    void remove(int id);
}
