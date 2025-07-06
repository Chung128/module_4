package com.example.su_dung_spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
    @GetMapping("/home")
    public String handleWelcome(){
        return "home";
    }
    @GetMapping("/admin/home")
    public String handleAdminWelcome(){
        return "home_admin";
    }
    @GetMapping("/user/home")
    public String handleUserWelcome(){
        return "home_user";
    }
}
