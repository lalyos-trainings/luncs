package com.acme.training.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value=2)
public class HungarianTruthAspect {

	@Around("execution(@com.acme.training.aop.Retry * *(..)) && @annotation(retry)")
	public Object retry(ProceedingJoinPoint joinPoint, Retry retry) {
		Object ret = null;

		System.out.println("[RETRY] max=" + retry.maxRetry());
		boolean end = false;
		int exceptionCounter = 0;
		do {
			try {
				System.out.println("[RETRY] before call ...");
				ret = joinPoint.proceed();
				System.out.println("[RETRY] after call ...");
				end = true;
			} catch (Throwable e) {
				exceptionCounter ++;
				System.out.println("[RETRY] exception: " + exceptionCounter);
				if (exceptionCounter >= retry.maxRetry()) {
					end = true;
					throw new RuntimeException("Retries exceeded ... (giving up) ", e);
				}
			}
		} while (!end);

		return ret;
	}
}
