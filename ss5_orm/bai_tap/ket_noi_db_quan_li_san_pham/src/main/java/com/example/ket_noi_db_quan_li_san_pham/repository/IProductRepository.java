package com.example.ket_noi_db_quan_li_san_pham.repository;

import com.example.ket_noi_db_quan_li_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void update( Product product);

    void remove(int id);

    List<Product> findByName(String name);
}
