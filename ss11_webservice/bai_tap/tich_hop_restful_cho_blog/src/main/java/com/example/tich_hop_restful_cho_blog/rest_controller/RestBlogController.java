package com.example.tich_hop_restful_cho_blog.rest_controller;


import com.example.tich_hop_restful_cho_blog.model.MyBlog;
import com.example.tich_hop_restful_cho_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/version1/blogs")
public class RestBlogController {
    private IBlogService blogService;

    @Autowired
    public RestBlogController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("")
    public ResponseEntity<List<MyBlog>> findAllBlog(){
        List<MyBlog> blogList=blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204 thành công nhưng không có kết quả
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK); //200 thành công
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<MyBlog>> findBlogById(@PathVariable int id){
        Optional<MyBlog> blogOptional=blogService.findById(id);
        if (blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 không tìm thấy
        }
        return new ResponseEntity<>(blogOptional,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MyBlog> addBlog(@RequestBody MyBlog myBlog){
        blogService.save(myBlog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MyBlog> updateBlog(@PathVariable int id,@RequestBody MyBlog myBlog){
        Optional<MyBlog> blogOptional=blogService.findById(id);
        if (blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.save(myBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyBlog> deleteBlog(@PathVariable int id){
        Optional<MyBlog> blogOptional=blogService.findById(id);
        if (blogOptional.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
