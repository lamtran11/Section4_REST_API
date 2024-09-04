package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	Student findById(int theId);
	
	Student save(Student theStudent);
	
	Student update(int theId);
	
	void deleteById(int theId);
	
	boolean emailExists(String email);
	
}
