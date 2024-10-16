package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.service.TrafficFortuneService;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class Section10AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section10AopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {
		
		return runner -> {
			
//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);			
			
//			demoTheAfterReturingAdvice(theAccountDAO);
			
//			demoAfterThrowingAdvice(theAccountDAO); 
			
//			demoAfterAdvice(theAccountDAO);
			
//			demoAroundAdvice(theTrafficFortuneService);
			
			//demoAroundAdviceHandleException(theTrafficFortuneService);
			
			demoAroundAdviceRethrowException(theTrafficFortuneService);

		};
	}
	
	
	private void demoAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		// TODO 自動生成されたメソッド・スタブ
		
        System.out.println("\n Main Program: demoAroundAdviceRethrowException");
        
        boolean tripWire = true;
        
        try {
            System.out.println("===>>> The fortune is: " + theTrafficFortuneService.getFortune(tripWire));
            
        } catch (Exception exc) {
            // Rethrow the exception to the caller of this method
            throw exc;
            
        } finally {
            System.out.println("===>>> End of main program");
            
        }
		
	}

	private void demoAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("\n Main Program: demoAroundAdviceHandleException");
		
		boolean tripWire = true;
		
		System.out.println("===>>> The fortune is: " + theTrafficFortuneService.getFortune(tripWire));
		
        System.out.println("===>>> End of main program");
		
	}

	private void demoAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("\n Main Program: demoAroundAdvice");
		
		System.out.println("===>>> The fortune is: " + theTrafficFortuneService.getFortune());
		
        System.out.println("===>>> End of main program");
		
	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {
		
		List<Account> theAccounts = null;
		
		try {
			//Add boolean flag to simulate exceptions
			boolean tripWire = false;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception exc) {
			
			System.out.println("\n............An exception occurred while retrieving accounts." + exc);
			
		}
			
		
		System.out.println("\n--- After finally Advice ---");
		
		System.out.println(theAccounts);
		
		System.out.println("\n--- After finally Advice ---");
	}

	private void demoAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		
		try {
			//Add boolean flag to simulate exceptions
			boolean tripWire = true;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception exc){
			System.out.println("\n............An exception occurred while retrieving accounts." + exc);
		}
			
		
		System.out.println("\n--- Throwing Advice ---");
		
		System.out.println(theAccounts);
		
		System.out.println("\n--- Throwing Advice ---");
		
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println(theAccounts);	
		
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// TODO 自動生成されたメソッド・スタブ
//		Account myAccount = new Account();
//		
//        myAccount.setName("Yamada");
//        myAccount.setLevel("gold");
//        
//		theAccountDAO.addAccount(myAccount, true);

//		theAccountDAO.doWork();
		
		theAccountDAO.setName("Hayashi");
		
        theAccountDAO.setServiceCode("silver");
        
        String name = theAccountDAO.getName();
        
        String serviceCode = theAccountDAO.getServiceCode();	
        
        
		theMembershipDAO.addMemberShip();		
		
//		theMembershipDAO.goToSleep();
		
	}

}










