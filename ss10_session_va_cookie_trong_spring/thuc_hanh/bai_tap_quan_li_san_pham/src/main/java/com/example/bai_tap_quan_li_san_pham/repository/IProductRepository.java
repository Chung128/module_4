package com.example.bai_tap_quan_li_san_pham.repository;

import com.example.bai_tap_quan_li_san_pham.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
