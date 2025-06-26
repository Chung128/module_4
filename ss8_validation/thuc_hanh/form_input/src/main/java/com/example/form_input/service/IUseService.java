package com.example.form_input.service;

import com.example.form_input.model.Use;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUseService {
    Page<Use> findAll(Pageable pageable);
    void save(Use use);

    Use findById(int id);

    void remove(int id);
    Page<Use> searchByName(String searchByName ,Pageable pageable);
}
