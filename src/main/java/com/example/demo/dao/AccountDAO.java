package com.example.demo.dao;

import com.example.demo.Account;

public interface AccountDAO {
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWork();
}
