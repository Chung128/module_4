package com.example.ket_noi_db_quan_li_san_pham.controller;

import com.example.ket_noi_db_quan_li_san_pham.model.Product;
import com.example.ket_noi_db_quan_li_san_pham.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
//        model.addAttribute("products",productService.findAll());
        return "list";
    }

    @GetMapping("create")
    public  String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("save")
    public String create(Product product, RedirectAttributes redirect){
        productService.add(product);
        redirect.addAttribute("success","Created product successfully");
        return "redirect:/products";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }

    @GetMapping("{id}/edit")
    public  String update(@PathVariable int id ,Model model){
        model.addAttribute("product",productService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(Product product,RedirectAttributes redirect){
        productService.update(product);
        redirect.addAttribute("success","Updated product successfully!");
        return "redirect:/products";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id,RedirectAttributes redirect){
        productService.remove(id);
        redirect.addAttribute("success","Delete product successfully!");
        return "redirect:/products";
    }

    @GetMapping("search")
    public  String search(@RequestParam(value = "name") String name , Model model){
        List<Product> productList;
        if (name!=null&&!name.isEmpty()){
            productList=productService.findByName(name);
        }else {
            productList=productService.findAll();
        }
        model.addAttribute("products",productList);
        model.addAttribute("name",name);
        return "list";
    }
}
