package com.example.RestControllerDemo.Rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestControllerDemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	//Define endpoint for /student 
	
	@GetMapping("/students")
	public List<Student> getStudent() {
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Hayashi", "Inage"));
		students.add(new Student("Miyu", "Miwako"));
		students.add(new Student("Yukiko", "Kanagawa"));
		
		
		return students;
		
	}
}



























