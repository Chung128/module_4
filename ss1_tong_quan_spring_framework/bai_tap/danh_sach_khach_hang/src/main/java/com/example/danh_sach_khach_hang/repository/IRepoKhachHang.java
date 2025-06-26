package com.example.danh_sach_khach_hang.repository;

import com.example.danh_sach_khach_hang.entity.KhachHang;

import java.util.List;

public interface IRepoKhachHang {
    List<KhachHang> findAll();
}
