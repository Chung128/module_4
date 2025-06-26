package com.example.demo.controller;


import com.example.demo.model.MyBlog;
import com.example.demo.service.IAuthorService;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    private IBlogService blogService;
    private IAuthorService authorService;

    @Autowired
    public BlogController(IBlogService blogService, IAuthorService authorService) {
        this.blogService = blogService;
        this.authorService = authorService;
    }

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("blogs",blogService.findAll());
        return "list";
    }

    @GetMapping("create")
    public  String create(Model model){
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("blog",new MyBlog());
        return "create";
    }

    @PostMapping("save")
    public String create(MyBlog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addAttribute("success","Create success!");
        return "redirect:/blogs";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "update";
    }

    @PostMapping("update")
    private String update(MyBlog blog,RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addAttribute("success","Update success!");
        return "redirect:/blogs";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id ,RedirectAttributes redirect){
        blogService.findById(id);
        redirect.addAttribute("success","Delete success!");
        return "redirect:/blogs";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable int id ,Model model){
        model.addAttribute("author",blogService.findById(id).getAuthor());
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }
}
