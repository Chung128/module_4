package com.example.tich_hop_security_cho_ung_dung_blog.service;


import com.example.tich_hop_security_cho_ung_dung_blog.model.MyBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<MyBlog> findAll();
    Page<MyBlog> findAll(Pageable pageable);

    void save(MyBlog blog);

    Optional<MyBlog> findById(int id);

    void remove(int id);
    Page<MyBlog> searchByName(String searchByName,int id ,Pageable pageable);
}
