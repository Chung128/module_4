package com.example.ung_dung_muon_sach.controller;


import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BorrowCode;
import com.example.ung_dung_muon_sach.service.IBookService;
import com.example.ung_dung_muon_sach.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/books")
public class BookController {
    private IBookService bookService;
    private IBorrowCodeService borrowCodeService;

    @Autowired
    public BookController(IBookService bookService, IBorrowCodeService borrowCodeService) {
        this.bookService = bookService;
        this.borrowCodeService = borrowCodeService;
    }

    @GetMapping("/{id}/detail")
    public String viewBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }


    // Mượn sách
    @PostMapping("/{id}/borrow")
    public String borrowBook(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            BorrowCode borrowCode = borrowCodeService.borrowBook(id);
            redirectAttributes.addFlashAttribute("success",
                    "Mượn sách thành công! Mã mượn: " + borrowCode.getCode());
        } catch (IllegalStateException e) {
            redirectAttributes.addFlashAttribute("error", "Không thể mượn sách: " + e.getMessage());
        }
        return "redirect:/books";
    }

    // Trả sách
    @GetMapping("/return")
    public String returnBook() {
        return "return_form";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        borrowCodeService.remove(id);
        redirectAttributes.addFlashAttribute("success","Đã xóa thành công");
        return "list_code";
    }

    @PostMapping("/return")
    public String doReturnBook(@RequestParam String code, RedirectAttributes redirectAttributes) {
        try {
            borrowCodeService.returnBook(code);
            redirectAttributes.addFlashAttribute("success", "Trả sách thành công.");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("error", "Không thể trả sách: " + e.getMessage());
        }
        return "redirect:/books";
    }

    @GetMapping("")
    public  String showList(Model model){
        model.addAttribute("books",bookService.findAll());
        return "list";
    }

    @GetMapping("/showCode")
    public  String showCode(Model model){
        model.addAttribute("code",borrowCodeService.findAll());
        return "list_code";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("book",new Book());
        return "create";
    }

    @PostMapping("save")
    public String create(Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("success","thêm mới thành công@");
        return "redirect:/books";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("book",bookService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(Book book,RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("success","Cập nhật thành công!");
        return "redirect:/books";
    }

}
