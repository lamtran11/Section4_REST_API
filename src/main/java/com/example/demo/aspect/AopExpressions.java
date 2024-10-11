package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//If dont have @Before, @After then @Aspect is optional
@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.example.demo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Pointcut("execution(* com.example.demo.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* com.example.demo.dao.*.set*(..))")
	private void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}

}
