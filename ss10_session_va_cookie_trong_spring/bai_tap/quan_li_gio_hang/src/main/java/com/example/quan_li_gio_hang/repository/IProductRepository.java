package com.example.quan_li_gio_hang.repository;

import com.example.quan_li_gio_hang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProductRepository extends JpaRepository<Product,Long> {
}
