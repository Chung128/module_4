package com.example.form_input.repository;

import com.example.form_input.model.Use;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUseRepository extends JpaRepository<Use,Integer> {


    @Query(value = "SELECT * FROM user WHERE last_name LIKE CONCAT('%', :searchName, '%')", nativeQuery = true)
    Page<Use> searchByName(@Param("searchName") String searchName, Pageable pageable);
}
