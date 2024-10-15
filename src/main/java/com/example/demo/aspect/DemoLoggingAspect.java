package com.example.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.example.demo.Account;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
	
	@AfterReturning(
		pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
		returning = "result")
	public void afterReturningFindAccountAdvices(JoinPoint theJoinPoint, List<Account> result) {
		//Print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n===>>> Executing @AfterReturning advice on findAccount()" + method);
		
		//Convert account names to uppercase
		convertAccountNamesToUppercase(result);
		
		//Print out the retults of method call 
		// => Do it below Uppercase method
	}
	
	
	private void convertAccountNamesToUppercase(List<Account> result) {
		
		for(Account temp: result) {
            temp.setName(temp.getName().toUpperCase());
        }
		
		System.out.println("===>>> After converting account names to uppercase");
		
		//Print out the retults of method call 
		System.out.println("===>>> Result is: " + result);
		
		
	}


	@Before("com.example.demo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("===>>> Executing @Before advice on addAccount()");
        
        //Display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        
        System.out.println("Method Signature: " + methodSignature);
        
        //Display method arguments
        
        //Get the method arguments
        Object[] args = theJoinPoint.getArgs();
        
        //Print the arguments
        for(Object temp: args) {
        	System.out.println("Argument: " + temp);
        	
        	if(temp instanceof Account) {
        		
        		Account theAccount = (Account) temp;
        		
        		System.out.println("Account Name: " + theAccount.getName());
        		System.out.println("Account Level: " + theAccount.getLevel());

        	}
        }
        
        System.out.println("===>>> End of beforeAddAccountAdvice()");
    }
	
}







