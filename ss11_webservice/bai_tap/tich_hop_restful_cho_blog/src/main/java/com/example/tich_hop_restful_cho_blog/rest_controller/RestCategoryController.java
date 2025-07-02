package com.example.tich_hop_restful_cho_blog.rest_controller;


import com.example.tich_hop_restful_cho_blog.model.Category;
import com.example.tich_hop_restful_cho_blog.model.MyBlog;
import com.example.tich_hop_restful_cho_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/version1/categories")
public class RestCategoryController {
    private ICategoryService categoryService;

    @Autowired
    public RestCategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categoryList=categoryService.findAll();
        if (categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> findBlogById(@PathVariable int id){
        Optional<Category> categoryOptional=categoryService.findById(id);
        if (categoryOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 không tìm thấy
        }
        return new ResponseEntity<>(categoryOptional,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> addBlog(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Category> updateBlog(@PathVariable int id,@RequestBody Category category){
        Optional<Category> categoryOptional=categoryService.findById(id);
        if (categoryOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteBlog(@PathVariable int id){
        Optional<Category> categoryOptional=categoryService.findById(id);
        if (categoryOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
