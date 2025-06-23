package com.example.quan_li_san_pham.service;

import com.example.quan_li_san_pham.model.Product;
import com.example.quan_li_san_pham.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
productRepository.update(product);
    }

    @Override
    public void remove(int id) {
productRepository.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
