package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AccountDAO;

@SpringBootApplication
public class Section10AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(Section10AopApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO) {
		
		return runner -> {
			
			demoTheBeforeAdvice(theAccountDAO);			
			
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {
		// TODO 自動生成されたメソッド・スタブ
		theAccountDAO.addAccount();
	}

}
