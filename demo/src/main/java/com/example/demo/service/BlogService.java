package com.example.demo.service;

import com.example.demo.model.MyBlog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    private IBlogRepository blogRepository;

    @Autowired
    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public List<MyBlog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(MyBlog blog) {
        blogRepository.save(blog);
    }

    @Override
    public MyBlog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }
}
