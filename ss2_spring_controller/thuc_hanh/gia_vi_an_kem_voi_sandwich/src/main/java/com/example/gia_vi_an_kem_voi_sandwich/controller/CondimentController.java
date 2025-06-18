package com.example.gia_vi_an_kem_voi_sandwich.controller;


import com.example.gia_vi_an_kem_voi_sandwich.service.ICondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {

    @Autowired
    private ICondimentService condimentService;

    @GetMapping("/condiments")
    public String save(@RequestParam(value = "condiment",required = false) String[] condiment,
                       @RequestParam(value = "action",required = false) String action,   //required = false không chọn gì k bị lỗi
                       Model model){
        if ("save".equals(action)&&!condimentService.validateCondiments(condiment)){ // kiểm tra báo lỗi nếu không chọn gì
            model.addAttribute("error","Không có loại gia vị nào được chọn");
        }else if (condiment!=null){          //nếu chọn ít nhất 1 gia vị  thì ok
            model.addAttribute("condiment",condiment);
        }
        return "save";   // trả về file save.jsp
    }
}
