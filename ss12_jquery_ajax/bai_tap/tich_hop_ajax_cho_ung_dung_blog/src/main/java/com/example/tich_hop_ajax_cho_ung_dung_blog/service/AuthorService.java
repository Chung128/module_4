package com.example.tich_hop_ajax_cho_ung_dung_blog.service;



import com.example.tich_hop_ajax_cho_ung_dung_blog.model.Author;
import com.example.tich_hop_ajax_cho_ung_dung_blog.repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{
    private IAuthorRepository authorRepository;

    @Autowired
    public AuthorService(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
