package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);
		
		Student theStudent = null;
		
		if(result.isPresent()) {
			theStudent = result.get();
		} else {
			throw new RuntimeException("The Student does not exist");
		}
		return theStudent;
	}

	@Override
	public Student save(Student theStudent) {
		
		return studentRepository.save(theStudent);
	}

	@Override
	public Student update(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void deleteById(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
	
	
}
