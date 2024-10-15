package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	private String name;

	private String serviceCode;

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(getClass() + ": DOING DB WORK: ADDING AN ACCOUNT\n");

	}

	@Override
	public boolean doWork() {

		System.out.println(getClass() + ": DOING DB WORK: Go To Working");

		return false;
	}

	@Override
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	@Override
	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	@Override
	public String getServiceCode() {
		System.out.println(getClass() + ": in getService()");
		return serviceCode;
	}

	@Override
	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setService()");
		this.serviceCode = serviceCode;
	}

	@Override
	public List<Account> findAccounts() {
		// TODO 自動生成されたメソッド・スタブ	
		return findAccounts(false);
	}
	
	@Override
	public List<Account> findAccounts(boolean tripWire) {
		
		if (tripWire) {
			
			throw new RuntimeException("TRIPWIRED: Returning Empty List");
			
		} 
		
		List<Account> myAccounts = new ArrayList<>();

		Account account1 = new Account("Hayashi", "Gold");
		Account account2 = new Account("Yamada", "Silver");
		Account account3 = new Account("Suzuki", "Bronze");

		myAccounts.add(account1);
		myAccounts.add(account2);
		myAccounts.add(account3);

		return myAccounts;
	}

}
