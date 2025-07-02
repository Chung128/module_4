package com.example.tich_hop_restful_cho_blog.service;




import com.example.tich_hop_restful_cho_blog.model.MyBlog;
import com.example.tich_hop_restful_cho_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Page<MyBlog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public void save(MyBlog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Optional<MyBlog> findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<MyBlog> searchByName(String searchByName, Pageable pageable) {
        return blogRepository.searchByName(searchByName,pageable);
    }
}
