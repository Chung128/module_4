package com.example.tich_hop_security_cho_ung_dung_blog.controller;



import com.example.tich_hop_security_cho_ung_dung_blog.model.Category;
import com.example.tich_hop_security_cho_ung_dung_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

        @GetMapping("")
    public String showForm( Model model){
        model.addAttribute("categoryPage",categoryService.findAll());
        return "list_category";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("categoryNew",new Category());
        return "create_category";
    }

    @PostMapping("save")
    public String create(Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("success","Created category success!");
        return "redirect:/categories";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "update_category";
    }

    @PostMapping("update")
    public String update(Category category,RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("success","Update category success!");
        return "redirect:/categories";
    }


    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id ,RedirectAttributes redirect){
        categoryService.remove(id);
        redirect.addFlashAttribute("success","Delete category success@");
        return "redirect:/categories";
    }
}
