package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
	private String name;
	
	private String serviceCode;

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


	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": in getService()");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setService()");
		this.serviceCode = serviceCode;
	}
	
	
}
