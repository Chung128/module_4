package com.example.form_input.controller;


import com.example.form_input.model.Use;
import com.example.form_input.service.IUseService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/uses")
public class UseController {
    private IUseService useService;

    @Autowired
    public UseController(IUseService useService) {
        this.useService = useService;
    }

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "") String lastName,
                           @RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "3") int size,
                           Model model) {
        Sort sort=Sort.by(Sort.Direction.ASC,"lastName");
        Pageable pageable= PageRequest.of(page,size,sort);
        Page<Use> usePage;
        if (lastName!=null&&!lastName.trim().isEmpty()){
            usePage=useService.searchByName(lastName,pageable);
        }else {
            usePage=useService.findAll(pageable);
        }
        model.addAttribute("usePage",usePage);
        model.addAttribute("lastName",lastName);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("use",new Use());
        return "create";
    }

//    @PostMapping("save")
//    public String create(Use use, RedirectAttributes redirect){
//        useService.save(use);
//        redirect.addFlashAttribute("success","Created category success!");
//        return "redirect:/uses";
//    }

    @PostMapping("save")
    public String create(@Validated Use use, BindingResult bindingResult,
                         RedirectAttributes redirect){
        new Use().validate(use,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        useService.save(use);
        redirect.addFlashAttribute("success","Created category success!");
        return "redirect:/uses";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("use",useService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(Use use,RedirectAttributes redirect){
        useService.save(use);
        redirect.addFlashAttribute("success","Update category success!");
        return "redirect:/uses";
    }


    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id ,RedirectAttributes redirect){
        useService.remove(id);
        redirect.addFlashAttribute("success","Delete category success!");
        return "redirect:/uses";
    }
    @GetMapping("{id}/detail")
    public String detail(@PathVariable int id ,Model model){
        model.addAttribute("use",useService.findById(id));
        return "detail";
    }
}
