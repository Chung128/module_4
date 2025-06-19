package com.example.luu_giu_thu_dien_tu.controller;


import com.example.luu_giu_thu_dien_tu.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @GetMapping("/emails")
    public String email(Model model){
        model.addAttribute("email",new Email());
        return "/update";
    }

    @PostMapping("/updateEmail")
    public String submit(@ModelAttribute Email email,Model model){
        model.addAttribute("language",new String[]{"english","vietnamese","japanese","chinese"});
        model.addAttribute("pageSize",new String[]{"5","10","15","25","50","100"});
        model.addAttribute("email",email);
        model.addAttribute("language",email.getLanguage());
        model.addAttribute("pageSize",email.getPageSize());
        model.addAttribute("filter",email.isFilter());
        model.addAttribute("signature",email.getSignature());
        return "/view";
    }

}
