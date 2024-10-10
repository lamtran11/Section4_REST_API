package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Override
	public void addAccount(Account theAccount,  boolean vipFlag) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(getClass() + ": DOING DB WORK: ADDING AN ACCOUNT\n");
		
	}

	
	@Override
	public boolean doWork() {
		
		System.out.println(getClass() + ": DOING DB WORK: Go To Working");
		
		return false;
	}
	
}
