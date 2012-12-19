package com.acme.training.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HereIComeAspect {

	@Before("execution(* com.acme.training..*.*(..) )")
	public void here(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().toString();
		System.out.format("Here I come ...: %s%n", name);
		
	}
}
