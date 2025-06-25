package com.example.nang_cap_my_blog.service;



import com.example.nang_cap_my_blog.model.MyBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<MyBlog> findAll();
    Page<MyBlog> findAll(Pageable pageable);

    void save(MyBlog blog);

    MyBlog findById(int id);

    void remove(int id);
    Page<MyBlog> searchByName(String searchByName ,Pageable pageable);
}
