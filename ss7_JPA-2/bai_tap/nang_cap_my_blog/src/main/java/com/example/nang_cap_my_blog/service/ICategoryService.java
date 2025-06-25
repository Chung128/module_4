package com.example.nang_cap_my_blog.service;


import com.example.nang_cap_my_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(int id);

    void remove(int id);
}
