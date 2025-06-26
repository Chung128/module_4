package com.example.custormer_management.repository;

import com.example.custormer_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findCustomerByNameContaining(String searchName);
    Page<Customer> findCustomerByNameContaining(String searchName, Pageable pageable);

//    @Query(value = "SELECT * FROM customers WHERE name LIKE CONCAT('%', :searchName, '%')", nativeQuery = true)
//    List<Customer> searchByName(@Param("searchName") String searchName);

    @Query(value = "SELECT * FROM customers WHERE name LIKE CONCAT('%', :searchName, '%')", nativeQuery = true)
    Page<Customer> searchByName(@Param("searchName") String searchName, Pageable pageable);
}
