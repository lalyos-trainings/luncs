package com.acme.training.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value=1)
public class TimerAspect{

	@Around("annotatedWithTimer()")
	public Object timer(ProceedingJoinPoint joinPoint) {
		Object ret = null;
		long startTime = System.currentTimeMillis();
		try {
			ret = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.format("%s method took %d ms%n", joinPoint.getSignature(),
				(endTime - startTime));
		return ret;
	}

	@Pointcut("execution(* com.acme..*.*(..))")
	public void allMethods() {

	}

	@Pointcut("execution(* com.acme..*.get*(..))")
	public void getMethods() {
	}

	@Pointcut("execution(java.util.Collection com.acme..*.*(..))")
	public void returnsCollectionMethods() {
	}
	
	@Pointcut("execution(@com.acme.training.aop.Timer * *(..))")
	public void annotatedWithTimer() {}

}
