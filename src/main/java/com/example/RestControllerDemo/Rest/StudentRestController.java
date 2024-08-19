package com.example.RestControllerDemo.Rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.com.example.RestControllerDemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	//Using post contruct fot load students data only once
	@PostConstruct
	public void loadStudents() {

		students = new ArrayList<Student>();

		students.add(new Student("Hayashi", "Inage"));
		students.add(new Student("Miyu", "Miwako"));
		students.add(new Student("Yukiko", "Kanagawa"));
	}

	//Define endpoint for /student 

	@GetMapping("/students")
	public List<Student> getStudent() {

		return students;

	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		return students.get(studentId);

	}

}
