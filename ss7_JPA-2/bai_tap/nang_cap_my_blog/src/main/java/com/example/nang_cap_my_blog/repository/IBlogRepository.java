package com.example.nang_cap_my_blog.repository;


import com.example.nang_cap_my_blog.model.MyBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<MyBlog,Integer> {
    @Query(value = "SELECT * FROM blogs WHERE title LIKE CONCAT('%', :searchName, '%')", nativeQuery = true)
    Page<MyBlog> searchByName(@Param("searchName") String searchName, Pageable pageable);
}
