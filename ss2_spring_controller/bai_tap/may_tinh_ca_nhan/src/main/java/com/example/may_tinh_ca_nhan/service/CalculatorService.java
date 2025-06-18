package com.example.may_tinh_ca_nhan.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public double calculate(double number1, double number2, String operator) {
        switch (operator){
            case "add":
                return  number1+number2;
            case "subtract":
                return number1-number2;
            case "multiply":
                return number1*number2;
            case "divide":
                if (number2==0){
                    throw new ArithmeticException("Không thể chia cho 0");
                }
                return number1/number2;
            default:
                throw new IllegalArgumentException("Hoạt động này không có");
        }
    }
}
