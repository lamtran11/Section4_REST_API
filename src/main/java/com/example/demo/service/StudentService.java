package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	Student findById(int theId);
	
	Student save(Student theStudent);
	
	Student update(Student student);
	
	void deleteById(int theId);
	
	boolean emailExists(String email);
	
	void deleteByIds(List<Integer> studentIds);
	
//	Student getStudentByEmail(Student student);
	
    Page<Student> findPaginated(int page, int size);

}
