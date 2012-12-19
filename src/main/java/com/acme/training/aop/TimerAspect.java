package com.acme.training.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {

	@Around("execution(* com.acme..*.*(..))")
	public Object timer(ProceedingJoinPoint joinPoint) {
		Object ret = null;
		long startTime = System.currentTimeMillis();
		try {
			ret = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.format("%s method took %d ms%n", joinPoint.getSignature(), (endTime-startTime));
		return ret;
	}
}
