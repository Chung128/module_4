package com.example.kiem_tra_email_hop_le;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller

public class EmailController {
    private static  final String EMAIL_REGEX= "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;

    public EmailController(){
        pattern=Pattern.compile(EMAIL_REGEX);
    }


    @GetMapping(value = "/email")
    public String email(){
        return "index";
    }

    @PostMapping(value = "/validate")
    public  String user(@RequestParam("email") String email,ModelMap modelMap){
        boolean isValidate =this.validate(email);
        if (!isValidate){
            modelMap.addAttribute("message","Email is invalidate");
            return "index";
        }
        modelMap.addAttribute("email",email);
        return "success";
    }

    private boolean validate(String regex){
        Matcher matcher=pattern.matcher((regex));
        return matcher.matches();
    }
}
