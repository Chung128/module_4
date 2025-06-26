package com.example.thong_tin_bai_hat.controller;


import com.example.thong_tin_bai_hat.model.Song;
import com.example.thong_tin_bai_hat.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
    private ISongService songService;

    @Autowired
    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songs",songService.findAll());
        return "list";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("song",new Song());
        return "create";
    }

    @PostMapping("save")
    public String create(@Validated Song song, BindingResult bindingResult,
                         RedirectAttributes redirect){
        new Song().validate(song,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        songService.save(song);
        redirect.addFlashAttribute("success","Created  success!");
        return "redirect:/songs";
    }

    @GetMapping("{id}/edit")
    public String update(@PathVariable int id, Model model){
        model.addAttribute("song",songService.findById(id));
        return "update";
    }

    @PostMapping("update")
    public String update(@Validated Song song, BindingResult bindingResult,
                         RedirectAttributes redirect){
        new Song().validate(song,bindingResult);
        if (bindingResult.hasErrors()){
            return "update";
        }
        songService.save(song);
        redirect.addFlashAttribute("success","Update  success!");
        return "redirect:/songs";
    }
}
