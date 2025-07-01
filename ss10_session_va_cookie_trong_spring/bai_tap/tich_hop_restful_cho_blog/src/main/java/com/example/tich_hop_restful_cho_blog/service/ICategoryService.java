package com.example.tich_hop_restful_cho_blog.service;



import com.example.tich_hop_restful_cho_blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Optional<Category> findById(int id);

    void remove(int id);
}
