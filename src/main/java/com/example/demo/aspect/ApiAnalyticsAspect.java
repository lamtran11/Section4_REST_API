package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class ApiAnalyticsAspect {
	
//	@Before("com.example.demo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
//	public void apiAnalyze() {
//		System.out.println("===>>> Executing @Before advice on API analyze()");
//	}
//	
}

