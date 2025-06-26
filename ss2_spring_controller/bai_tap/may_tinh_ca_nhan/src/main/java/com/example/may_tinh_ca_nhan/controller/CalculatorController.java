package com.example.may_tinh_ca_nhan.controller;


import com.example.may_tinh_ca_nhan.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/")
    //đường dẫn hiển thị form ban đầu
    public String showCalculator(){
        return "calculator";
    }

    @GetMapping("/calculate")
    public String calculator(@RequestParam(value = "number1",required = false) String number1,
                             @RequestParam(value = "number2",required = false) String number2,
                             @RequestParam(value = "operation",required = false) String operation,
                             Model model){
        try {
            if (number1 == null || number2 == null || operation == null) {
                model.addAttribute("error", "Vui lòng nhập đầy đủ số và phép toán");
                return "calculator";
            }
            double num1 = Double.parseDouble(number1);
            double num2 = Double.parseDouble(number2);
            double result = calculatorService.calculate(num1, num2, operation);
            model.addAttribute("result", result);
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Vui lòng nhập số hợp lệ");
        } catch (ArithmeticException e) {
            model.addAttribute("error", e.getMessage());
        }
//        double result = calculatorService.calculate(number1, number2, operation);
//        model.addAttribute("result", result);
//        model.addAttribute("operation", operation);

        return "calculator";
    }
}
