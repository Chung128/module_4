package com.example.danh_sach_khach_hang.repository;

import com.example.danh_sach_khach_hang.entity.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class RepoKhachHang implements IRepoKhachHang{
    @Autowired
    private static final List<KhachHang> khachHangList=new ArrayList<>();
    static {
        khachHangList.add(new KhachHang(1,"Trần Văn Chung","chung@gmail.com","Quảng Bình"));
        khachHangList.add(new KhachHang(2,"Trần Văn Khánh","khanh@gmail.com","Đà Nẵng"));
        khachHangList.add(new KhachHang(3,"Trần Văn Duy","duy@gmail.com","Quảng Trị"));
    }
    @Override
    public List<KhachHang> findAll() {
        return khachHangList;
    }
}
