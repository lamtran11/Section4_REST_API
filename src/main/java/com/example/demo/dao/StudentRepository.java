package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	 boolean existsByEmail(String email);

//	Optional<Student> getStudentByEmail(String email);
	
	 Page<Student> findPaginated(Pageable pageable); 
}
