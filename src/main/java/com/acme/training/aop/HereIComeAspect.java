package com.acme.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HereIComeAspect {

    @Before("execution(java.util.Collection com.acme.training..*.*(*))")
    public void here(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature()
                                     .toString();
        System.out.format("Here I come ... %s%n", methodName);
        for (Object arg : joinPoint.getArgs()) {
            System.out.format("    next arg: %i%n", arg);
        }
    }
}
