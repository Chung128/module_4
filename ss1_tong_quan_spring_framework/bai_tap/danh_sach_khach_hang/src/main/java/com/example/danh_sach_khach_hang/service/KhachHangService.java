package com.example.danh_sach_khach_hang.service;

import com.example.danh_sach_khach_hang.entity.KhachHang;
import com.example.danh_sach_khach_hang.repository.IRepoKhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService implements IKhachHangService{
    @Autowired
    private IRepoKhachHang repoKhachHang;

    @Override
    public List<KhachHang> findAll() {
        return repoKhachHang.findAll();
    }
}
