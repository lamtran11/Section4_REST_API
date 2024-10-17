package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	//set up logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	//set up pointcut
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
	private void forControllerPackage() {

	}

	//same pointcut for service and dao
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
	private void forServicePackage() {

	}

	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
	private void forDaoPackage() {

	}

	//combine pointcut
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {

	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();

		myLogger.info("===>>> Executing @Before method-------------------: " + methodName);

		//display method arguments
		Object[] args = joinPoint.getArgs();

		//log arguments if any present
		for (Object arg : args) {
			myLogger.info("=======> Argument: " + arg);
		}
	}

	// add @After advice
	// @After returning advice will be called after the method execution
	// but it will not be called if an exception is thrown
	@AfterReturning(
			pointcut = "forAppFlow()",
			returning = "result") // the name of the method parameter where the return value will be stored
	public void after(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().toShortString();

		myLogger.info("===>>> Executing @After method -------------------: " + result);

		//display method arguments
//		Object[] args = joinPoint.getArgs();
//
//		//log arguments if any present
//		
//		for (Object tempArg : args) {
//			myLogger.info("=======> argument: " + tempArg);
//		}
	}

}








