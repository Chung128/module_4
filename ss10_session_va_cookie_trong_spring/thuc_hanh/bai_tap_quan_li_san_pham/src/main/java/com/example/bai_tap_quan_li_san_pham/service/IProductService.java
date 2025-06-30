package com.example.bai_tap_quan_li_san_pham.service;

import com.example.bai_tap_quan_li_san_pham.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);
}
