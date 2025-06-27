package com.example.ung_dung_muon_sach.repository;

import com.example.ung_dung_muon_sach.model.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode,Integer> {
    Optional<BorrowCode> findByCode(String code);
}
