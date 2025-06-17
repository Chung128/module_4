package com.example.chuyen_doi_tien_te.controller;

import com.example.chuyen_doi_tien_te.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private ConvertService convertService;
    @GetMapping("/convert")
    public String showForm() {
        return "/result";
    }
    @GetMapping("/converts")
    public String convert(@RequestParam("vnd") double vndAmount, Model model) {
        double usd=convertService.convertUsdToVnd(vndAmount);
        model.addAttribute("usd",vndAmount);
        model.addAttribute("vnd",usd);
        return "result";    //chỗ này là hiển thị ở result.jsp
    }
}
