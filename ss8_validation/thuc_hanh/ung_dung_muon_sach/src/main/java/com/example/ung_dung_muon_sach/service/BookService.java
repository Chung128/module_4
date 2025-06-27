package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repository.IBookRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService implements IBookService{
    private IBookRepository bookRepository;

    @Autowired
    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book song) {
bookRepository.save(song);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
