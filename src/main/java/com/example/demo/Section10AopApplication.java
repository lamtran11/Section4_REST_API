package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;

@SpringBootApplication
public class Section10AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section10AopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		return runner -> {
			
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);			
			
		};
	}


	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// TODO 自動生成されたメソッド・スタブ
		Account myAccount = new Account();
		
		theAccountDAO.addAccount(myAccount);
		
		theMembershipDAO.addMemberShip();		
		
	}

}