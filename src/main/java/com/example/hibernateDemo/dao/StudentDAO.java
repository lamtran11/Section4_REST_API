package com.example.hibernateDemo.dao;

import java.util.List;

import com.example.hibernateDemo.entity.Student;

public interface StudentDAO {
	
	void save(Student student);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String lastName);
	
	void update(Student student);
	
	void delete(Integer id);
	
	int deleteAll();
}
