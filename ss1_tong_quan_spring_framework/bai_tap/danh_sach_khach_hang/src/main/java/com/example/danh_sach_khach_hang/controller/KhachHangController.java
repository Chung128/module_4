package com.example.danh_sach_khach_hang.controller;


import com.example.danh_sach_khach_hang.entity.KhachHang;
import com.example.danh_sach_khach_hang.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class KhachHangController {
    @Autowired
    private IKhachHangService khachHangService;
    @GetMapping("/list")
    public String showList(Model model){
        List<KhachHang> khachHangList=khachHangService.findAll();
        model.addAttribute("khachHangList",khachHangList);
        return "list";
    }
}
