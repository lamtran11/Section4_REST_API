package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	Student findById(int theId);
	
//	List<Student> findByLastName(String theLastName);
//	
//	List<Student> findByEmail(String email);

	Student save(Student theStudent);
	
	Student update(Student student);
	
	void deleteById(int theId);
	
	boolean emailExists(String email);
	
	void deleteByIds(List<Integer> studentIds);
		
//    Page<Student> findPaginated(int page, int size);

	
//	List<Student> saveAll(List<Student> students);
//	
//	
//	Iterable<Student> getAllStudents(Integer pageSize, Integer offset);
	
//	Page<Student> findPaginated(int pageNo, int pageSize);
	
//	List<Student> findByLastNameContainingAndEmailContaining(String lastName, String email);
	
	List<Student> findByLastNameContainingIgnoreCase(String lastName);

	// Method to find students by email
	List<Student> findByEmailContainingIgnoreCase(String email);

	// Method to find students by last name or email
	List<Student> findByLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String lastName, String email);
	
}
