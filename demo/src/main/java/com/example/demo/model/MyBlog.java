package com.example.demo.model;


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
@Table(name = "blogs")
public class MyBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title; //tiêu đề
    private String content;  //nội dung bài viết

//    @ManyToOne
//    @JoinColumn(name = "usename",unique = true)
    private String author;   //tên tác giả
    private LocalDate createAt; //ngày tạo
}
