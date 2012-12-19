package com.acme.training.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HereIComeAspect {

	@Before("execution(* com.acme.training.service.*.*(..) )")
	public void here() {
		System.out.println("Here I come ...");
	}
}
