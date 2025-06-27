package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.BorrowCode;

import java.util.List;

public interface IBorrowCodeService {
    List<BorrowCode> findAll();
    void save(BorrowCode song);

    BorrowCode findById(int id);
    void remove(int id);
    BorrowCode borrowBook(int bookId);
    void returnBook(String code);
}
