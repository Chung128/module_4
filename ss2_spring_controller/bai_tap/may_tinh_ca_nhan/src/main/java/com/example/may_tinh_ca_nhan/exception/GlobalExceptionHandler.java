package com.example.may_tinh_ca_nhan.exception;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
    // Xử lý lỗi chia cho 0
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException ex, Model model) {
        model.addAttribute("error", "Lỗi: " + ex.getMessage());
        return "calculator";
    }

    // Xử lý lỗi nhập liệu không hợp lệ
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatchException(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("error", "Lỗi: Vui lòng nhập số hợp lệ");
        return "calculator";
    }

    // Xử lý lỗi chung
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("error", "Lỗi: " + ex.getMessage());
        return "calculator";
    }
}
