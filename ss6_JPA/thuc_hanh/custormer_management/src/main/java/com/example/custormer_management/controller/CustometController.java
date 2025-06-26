package com.example.custormer_management.controller;


import com.example.custormer_management.model.Customer;
import com.example.custormer_management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")

public class CustometController {
    @Autowired
    private ICustomerService customerService;

//    @GetMapping("")
//    public String showForm(Model model){
//        model.addAttribute("customers",customerService.findAll());
//        return "list";
//    }

//    @GetMapping("")
//    public String showForm(@PageableDefault(page = 0,size = 2) Pageable pageable, Model model){
//        Page<Customer> customerPage = customerService.findAll(pageable);
//        model.addAttribute("customerPage",customerPage);
//        return "list";
//    }

    @GetMapping("")
    public String searchByName(@RequestParam (required = false,defaultValue ="")String name,
                               @RequestParam(required = false,defaultValue = "0")int page,
                               @RequestParam(required = false,defaultValue = "3") int size,
                               Model model){
        Sort sort=Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Customer> customerPage;
        if (name!=null&&!name.trim().isEmpty()){
            customerPage=customerService.searchByName(name,pageable);
        }else {
            customerPage=customerService.findAll(pageable);
        }
        model.addAttribute("customerPage",customerPage);
        model.addAttribute("name",name);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }

    @PostMapping("save")
    public String create(Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addAttribute("success","Created customer success!");
        return "redirect:/customers";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(Customer customer,RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addAttribute("success","Update customer success!");
        return "redirect:/customers";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable int id,Model model){
        model.addAttribute("customer",customerService.findById(id));
        return "detail";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id ,RedirectAttributes redirect){
        customerService.remove(id);
        redirect.addAttribute("success","Delete customer success@");
        return "redirect:/customers";
    }


}
