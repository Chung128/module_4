package com.example.ung_dung_muon_sach.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borrow_code")
public class BorrowCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @ManyToOne
    @JoinColumn(name ="book_id")
    private Book book;
    @Column(unique = true, length = 5)
    private String code;
    private LocalDate date;
    // trường trạng thái đã trả hay chưa
    private boolean returned;
}
