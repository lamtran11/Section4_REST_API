package com.example.RestControllerDemo.Rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.RestControllerDemo.Rest.StudentErrorResponse;
import com.example.RestControllerDemo.Rest.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.RestControllerDemo.entity.Student;

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

		//Just index into the list


		//Check the studentId again list size
		if (studentId < 0 || studentId >= students.size()) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		//Return the student from the list
		return students.get(studentId);

	}
	//Add an exception handler using @ExceptHandler
}

































