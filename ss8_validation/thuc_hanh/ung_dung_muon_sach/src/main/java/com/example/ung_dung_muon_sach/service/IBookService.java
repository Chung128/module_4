package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void save(Book song);

    Book findById(int id);
}
