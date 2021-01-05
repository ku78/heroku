package com.geekbrains.shop.aspect;

import com.geekbrains.shop.entities.MethodLogDetails;
import com.geekbrains.shop.service.SessionObjectHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogAspect {
    private final SessionObjectHolder sessionObjectHolder;

    public LogAspect(SessionObjectHolder sessionObjectHolder) {
        this.sessionObjectHolder = sessionObjectHolder;
    }

    @Pointcut("execution(* com.geekbrains.shop.controller..*.*(..))")
    private void anyMethod() {
    }

    @Before("anyMethod()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Log before ->" + joinPoint);
    }

    @After("anyMethod()")
    public void logAfter(JoinPoint joinPoint) {
        sessionObjectHolder.getLogDetails().add(new MethodLogDetails(LocalDateTime.now(), joinPoint.getTarget().getClass(), joinPoint.toLongString()));
    }

}
