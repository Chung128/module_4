package com.example.tich_hop_security_cho_ung_dung_blog.controller;



import com.example.tich_hop_security_cho_ung_dung_blog.model.MyBlog;
import com.example.tich_hop_security_cho_ung_dung_blog.service.IAuthorService;
import com.example.tich_hop_security_cho_ung_dung_blog.service.IBlogService;
import com.example.tich_hop_security_cho_ung_dung_blog.service.ICategoryService;
import com.example.tich_hop_security_cho_ung_dung_blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/blogs")
public class BlogController {
    private IBlogService blogService;
    private IAuthorService authorService;
    private ICategoryService categoryService;
    private IUserService userService;

    @Autowired
    public BlogController(IBlogService blogService, IAuthorService authorService, ICategoryService categoryService) {
        this.blogService = blogService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


//    @GetMapping("")
//    public String showList(Model model){
//        model.addAttribute("blogs",blogService.findAll());
//        return "list";
//    }

    @GetMapping("")
    public String searchByName(@RequestParam(required = false,defaultValue ="")String title,
                               @RequestParam(required = false,defaultValue = "0")int page,
                               @RequestParam(required = false,defaultValue = "3") int size,
                               @RequestParam(required = false,defaultValue = "3") int id,
                               Model model){
        Sort sort=Sort.by(Sort.Direction.ASC,"title");
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<MyBlog> blogPage;
        if (title!=null&&!title.trim().isEmpty()){
            blogPage=blogService.searchByName(title,id,pageable);
        }else {
            blogPage=blogService.findAll(pageable);
        }
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("title",title);
        model.addAttribute("categoryId", id);
        model.addAttribute("categories", categoryService.findAll());
        return "list";
    }

    @GetMapping("create")
    public  String create( Model model){
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("blog",new MyBlog());
        return "create";
    }

    @PostMapping("save")
    public String create(MyBlog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("success","Create success!");
        return "redirect:/blogs";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable int id,Model model){
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("blog",blogService.findById(id));
        return "update";
    }

    @PostMapping("update")
    private String update(MyBlog blog,RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("success","Update success!");
        return "redirect:/blogs";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id ,RedirectAttributes redirect){
        blogService.remove(id);
        redirect.addFlashAttribute("success","Delete success!");
        return "redirect:/blogs";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable int id ,Model model){
        model.addAttribute("categories",categoryService.findById(id));
        model.addAttribute("authors",blogService.findById(id));
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }

    //cho người dùng tìm kiếm khi chưa đăng nhập
//    @GetMapping("/search")
//    public String search(@RequestParam(required = false,defaultValue ="")String title,
//                               @RequestParam(required = false,defaultValue = "0")int page,
//                               @RequestParam(required = false,defaultValue = "3") int size,
//                               @RequestParam(required = false,defaultValue = "3") int id,
//                               Model model){
//        Sort sort=Sort.by(Sort.Direction.ASC,"title");
//        Pageable pageable= PageRequest.of(page,size,sort);
//        Page<MyBlog> blogPage;
//        if (title!=null&&!title.trim().isEmpty()){
//            blogPage=blogService.searchByName(title,id,pageable);
//        }else {
//            blogPage=blogService.findAll(pageable);
//        }
//        model.addAttribute("blogPage",blogPage);
//        model.addAttribute("title",title);
//        model.addAttribute("categoryId", id);
//        model.addAttribute("categories", categoryService.findAll());
//        return "list";
//    }

    //    CODE SPRING SECURITY
    @GetMapping("/home")
    public String showHome(Model model) {
        System.out.println("🔥 Vào controller trang home");
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "createAt"));
        Page<MyBlog> latestBlogs = blogService.findAll(pageable);
        model.addAttribute("categories",categoryService.findAll());
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("blogs", latestBlogs.getContent());
        return "home";
    }

    @GetMapping("/login")
    public String handleLogin(){
        return "login";
    }
}
