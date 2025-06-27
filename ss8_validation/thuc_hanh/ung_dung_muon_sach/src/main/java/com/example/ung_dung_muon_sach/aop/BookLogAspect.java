package com.example.ung_dung_muon_sach.aop;


import com.example.ung_dung_muon_sach.model.BorrowCode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


@Aspect
@Component
public class BookLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(BookLogAspect.class);

    //biến này đếm lượt truy cập
    private  final AtomicInteger visitCounter=new AtomicInteger(0);

    // logg mỗi lần có ngoười truy cập vào controller
    @Before("execution(* com.example.ung_dung_muon_sach.controller.BookController.*(..))")
    public void logVisit(JoinPoint joinPoint) {
        int visitCount = visitCounter.incrementAndGet();
        logger.info("Lượt truy cập thứ {}: {}()", visitCount, joinPoint.getSignature().getName());
    }

    // Ghi log khi mượn sách thành công
    @AfterReturning(
            pointcut = "execution(* com.example.ung_dung_muon_sach.service.IBorrowCodeService.borrowBook(..))",
            returning = "borrowCode")
    public void logAfterBorrow(JoinPoint joinPoint, Object borrowCode) {
        if (borrowCode instanceof BorrowCode code) {
            logger.info(" Mượn sách thành công - Mã mượn: {}, Tên sách: {}", code.getCode(), code.getBook().getTitle());
        }
    }

    // Ghi log khi trả sách thành công
    @AfterReturning("execution(* com.example.ung_dung_muon_sach.service.IBorrowCodeService.returnBook(..))")
    public void logAfterReturn(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        String code = (String) args[0];
        logger.info(" Trả sách thành công - Mã mượn: {}", code);
    }

    @AfterThrowing(pointcut = "execution(* com.example.ung_dung_muon_sach.service.IBorrowCodeService.*(..))", throwing = "ex")
    public void logBorrowOrReturnError(Exception ex) {
        logger.error("Lỗi khi mượn/trả sách: {}", ex.getMessage());
    }
}
