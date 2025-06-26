package com.example.custormer_management.service;

import com.example.custormer_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(int id);

    void remove(int id);
    Page<Customer> searchByName( String searchName,Pageable pageable);
}
