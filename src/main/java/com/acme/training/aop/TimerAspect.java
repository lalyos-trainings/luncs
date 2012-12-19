package com.acme.training.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

    @Around("execution(* com.acme..*.*(..))")
    public void timer(ProceedingJoinPoint pjp) {
        Long start = System.currentTimeMillis();
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.format("Time: %d%n", end - start);
    }
}
