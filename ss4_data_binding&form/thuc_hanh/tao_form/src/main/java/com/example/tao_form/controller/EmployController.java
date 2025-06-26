package com.example.tao_form.controller;


import com.example.tao_form.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("employee")
public class EmployController {

    @GetMapping("/showForm")
    public  String showForm(Model model){
        model.addAttribute("employee",new Employee());
        return "create";
    }

    @PostMapping("/addEmployee")
    public String submit(@ModelAttribute Employee employee,Model model){
        model.addAttribute("id",employee.getId());
        model.addAttribute("name",employee.getName());
        model.addAttribute("contact",employee.getContactNumber());
        return "info";
    }
}
