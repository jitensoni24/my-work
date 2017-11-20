package com.bskyb.db.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogTime {

	/**
	 * Annotated our method with @Around. <br>
	 * This is our advice, and around advice means we are adding extra code both before 
	 * and after method execution. <br>
	 * <p>
	 * And @Around annotation has a point cut argument. Our pointcut just says, 
	 * ‘Apply this advice any method which is annotated with @LogExecutionTime.’
	 * </p>
	 * @param jointPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint jointPoint) throws Throwable {
		long start = System.currentTimeMillis();
		
		Object proceed = jointPoint.proceed();
		
		long executionTime = System.currentTimeMillis() - start;

		System.out.println(jointPoint.getSignature() + " executed in " + executionTime + "ms");
		
		return proceed;
	}
}
