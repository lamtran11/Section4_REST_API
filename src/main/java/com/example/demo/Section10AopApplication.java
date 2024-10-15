package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;

@SpringBootApplication
//@EnableAspectJAutoProxy
public class Section10AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section10AopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		return runner -> {
			
//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);			
			
//			demoTheAfterAdvice(theAccountDAO);
			
			demoAfterThrowingAdvice(theAccountDAO); 
		};
	}
	
	
	private void demoAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		
		try {
			//Add boolean flag to simulate exceptions
			boolean tripWire = true;
			
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception exc){
			System.out.println("............An exception occurred while retrieving accounts." + exc);
		}
			
		
		System.out.println("\n--- Throwing Advice ---");
		
		System.out.println(theAccounts);
		
		System.out.println("\n--- Throwing Advice ---");
		
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		System.out.println("\n--- After Advice ---");
		
		System.out.println(theAccounts);
		
		System.out.println("===>>> End of afterAdvice()");
		
		
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










