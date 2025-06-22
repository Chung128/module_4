package com.example.quan_li_san_pham.repository;

import com.example.quan_li_san_pham.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{

    @Autowired
    private static final List<Product> productList=new ArrayList<>();
    static {
        productList.add(new Product(1, "Laptop Dell XPS 13", 25999.99, "Laptop cao cấp, mỏng nhẹ", "Dell"));
        productList.add(new Product(2, "iPhone 14 Pro", 32999.00, "Điện thoại flagship của Apple", "Apple"));
        productList.add(new Product(3, "Samsung Galaxy S24", 27999.50, "Điện thoại cao cấp mới nhất", "Samsung"));
        productList.add(new Product(4, "Tai nghe Sony WH-1000XM5", 8999.00, "Tai nghe chống ồn cực tốt", "Sony"));
        productList.add(new Product(5, "Máy ảnh Canon EOS M50", 18999.90, "Máy ảnh không gương lật", "Canon"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        for (int i = 0; i < productList.size(); i++) {

        }
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update( Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        return List.of();
    }
}
