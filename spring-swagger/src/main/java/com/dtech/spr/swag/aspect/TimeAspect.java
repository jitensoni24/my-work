package com.dtech.spr.swag.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimeAspect {

	@Around("@annotation(com.dtech.spr.swag.aspect.LogExectionTime)")
	public Object logTime(ProceedingJoinPoint jointPoint) throws Throwable {

		StopWatch watch = new StopWatch("logTime");
		
		watch.start();
		
		Object proceed = jointPoint.proceed();

		watch.stop();
		
		System.out.println("Execution took [ " + watch.getTotalTimeMillis() + " ms ]");
		
		return proceed;
	}

}
