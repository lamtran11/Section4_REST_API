package com.example.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
	
	@Before("execution(* add*(com.example.demo.Account))")
	public void beforeAddAccountAdvice() {
        System.out.println("\n===>>> Executing @Before advice on addAccount()\n");
    }
	
}



