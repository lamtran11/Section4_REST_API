package com.thymeleaf.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	//Create mapping for hello
	//localhost:8080/hello
	
	@GetMapping("/hello")
    //Return hello.html template when hello is requested
	public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
        
        return "helloworld"; //hello.html template is returned
    }
	
}
