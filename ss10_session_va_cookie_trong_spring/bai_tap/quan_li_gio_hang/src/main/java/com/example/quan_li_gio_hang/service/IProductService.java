package com.example.quan_li_gio_hang.service;


import com.example.quan_li_gio_hang.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Optional<Product> findById(Long id);
    void remove(Long id);
}
