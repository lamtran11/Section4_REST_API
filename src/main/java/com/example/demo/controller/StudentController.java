package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/studentList")
	public String getStudentList(Model theModel) {
		
		List<Student> studentList = studentService.findAll();
		
		theModel.addAttribute("student", studentList);
		
		return "student/studentList";
	}
	
	@GetMapping("/add")
	public String showFormAdd(Model theModel) {
		
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		
		return "student/student-form";
	}
	
}
