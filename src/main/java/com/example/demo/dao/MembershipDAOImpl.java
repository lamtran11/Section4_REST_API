package com.example.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

	@Override
	public boolean addMemberShip() {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println(getClass() + ": DOING DB WORK: ADDING A MEMBERSHIP");
		
		return true; // assuming successful membership addition
	}

}
