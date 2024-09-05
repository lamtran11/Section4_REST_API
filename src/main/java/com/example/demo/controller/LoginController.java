package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String returnStudentListPage() {

		return "redirect:/students/studentList";

    }
	
	@GetMapping("/showLoginPage")
	public String homePage() {

		return "home-page";
    }
	
	@GetMapping("/access-denied")
	public String accessDeniedPage() {

        return "access-denied";
    }
}
