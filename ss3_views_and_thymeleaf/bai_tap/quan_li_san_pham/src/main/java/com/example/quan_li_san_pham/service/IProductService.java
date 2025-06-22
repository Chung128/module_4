package com.example.quan_li_san_pham.service;

import com.example.quan_li_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
