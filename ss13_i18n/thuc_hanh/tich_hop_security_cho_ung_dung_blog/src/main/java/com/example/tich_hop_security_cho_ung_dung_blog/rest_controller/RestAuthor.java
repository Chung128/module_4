package com.example.tich_hop_security_cho_ung_dung_blog.rest_controller;


import com.example.tich_hop_security_cho_ung_dung_blog.model.Author;
import com.example.tich_hop_security_cho_ung_dung_blog.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/version1/authors")
public class RestAuthor {
    private IAuthorService authorService;

    @Autowired
    public RestAuthor(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAllCategory(){
        List<Author> authorList=authorService.findAll();
        if (authorList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(authorList,HttpStatus.OK);
    }
}
