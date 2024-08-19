package com.example.RestControllerDemo.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {
	
	@GetMapping("/hello")
	public String sayHello() {
		
		// Simulate a slow response time to test the API's performance'
		return "Hello";
	}
}
