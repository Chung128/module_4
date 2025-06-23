package com.example.ket_noi_db_quan_li_san_pham.service;

import com.example.ket_noi_db_quan_li_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
