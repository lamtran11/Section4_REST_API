package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	private List<String> countries;
	
	@Value("${languages}")
	private List<String> languages;
	
	@Value("${systems}")
	private List<String> systems;
	
	//Create mapping show form
	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		
		//create student object
		Student student = new Student();
		
		//add object to the model
		model.addAttribute("student", student);
		
		model.addAttribute("countries", countries);
		
		model.addAttribute("languages", languages);
		
		model.addAttribute("systems", systems);
        //return the form page
		return "student-form";
	}
	
	//process form submission
	@PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student student) {
		
        //add student object to the model
//		model.addAttribute("student", student);
		
		//return the form page
		return "student-confirmation";
    }
}






