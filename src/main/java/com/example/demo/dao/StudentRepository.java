package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	boolean existsByEmail(String email);

	//	Optional<Student> getStudentByEmail(String email);

	//	 Page<Student> findAllById(int theId, Pageable pageable);

	//	 String findByLastName(String theLastName);

	//	 List<Student> findByLastNameContainingAndEmailContaining(String lastName, String email);

	List<Student> findByLastNameContainingIgnoreCase(String lastName);

	// Method to find students by email
	List<Student> findByEmailContainingIgnoreCase(String email);

	// Method to find students by last name or email
	List<Student> findByLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String lastName, String email);
}











