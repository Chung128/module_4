package com.example.tu_dien_anh_viet.controller;


import com.example.tu_dien_anh_viet.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }
    @GetMapping("/convert")
    public String showForm(){
        return "dictionary";
    }
    @GetMapping("/dictionarys")
    public String convert(
            @RequestParam("word") String word,
            @RequestParam("direction") String direction,
            Model model) {
        String result = dictionaryService.translate(word, direction);
        model.addAttribute("word", word);
        model.addAttribute("direction", direction);
        if (result == null || result.isEmpty()) {
            model.addAttribute("notFound", true);
        } else {
            model.addAttribute("result", result);
        }
        return "dictionary";
    }
}
