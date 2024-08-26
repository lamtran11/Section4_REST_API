package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	//Handle get HTML form
	@GetMapping("/showform")
	public String getForm() {
		return "helloworld-form";
	}
	
	//Handle form submission
	@RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
	
	@RequestMapping("/processFormVersion2")
	public String processFormVersion2(HttpServletRequest request, Model model) {
		
		//Read the request parameters form HTML form
		String theName = request.getParameter("studentName");
		
		//convert data to upper case
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Konnichiwa From Japan To " + theName;
		
		//add the message to the model
         model.addAttribute("message", result);
        
        //return the view name "helloworld" to display the message
		return "helloworld";
		
	}
	
	
	@GetMapping("/processFormVersionAnnotation")
	public String processFormVersionAnnotation(@RequestParam("studentName") String theName, 
												Model model) {
		
		//convert data to upper case
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Ohayou From Tokyo To " + theName;
		
		//add the message to the model
         model.addAttribute("message", result);
        
        //return the view name "helloworld" to display the message
		return "helloworld";
		
	}
}















