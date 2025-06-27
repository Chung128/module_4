package com.example.thong_tin_bai_hat.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    private static int count=0;

    @After("execution(* com.example.thong_tin_bai_hat.controller.SongController.showList(..))")
    public void countUseVisitedList(){
        count++;
        System.out.println("chạy");
    }
}
