package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	//Add init binder to trim space
	//Remove white space 
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
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

	@PostMapping("/save")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			// Return the form view to display the validation errors
			return "student/student-form";
		}

		if (studentService.emailExists(theStudent.getEmail())) {

			theBindingResult.rejectValue("email", "error.student.email", "Emailが重複しました。");
			return "student/student-form";
		}

		// Save the student and redirect to the student list
		studentService.save(theStudent);
		return "redirect:/students/studentList";

	}

	@GetMapping("/update")
	public String showFormUpdate(@RequestParam("studentId") int theId, Model theModel) {

		Student theStudent = studentService.findById(theId);

		theModel.addAttribute("student", theStudent);

		return "student/student-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {

		studentService.deleteById(theId);

		return "redirect:/students/studentList";
	}
}
