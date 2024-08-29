package com.example.springCrudDemo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springCrudDemo.entity.Employee;
import com.example.springCrudDemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

     public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")  // Mapping the request to /employees/all
    // Implementing the logic to fetch all employees from the service layer and return them as a view.
    public String getAllEmployees(Model theModel) {

        List<Employee> employeeList = employeeService.findAll();

        theModel.addAttribute("employees", employeeList);

        return "employees/list-employees";

    }

    // Mapping the request to /employees/add
    @GetMapping("/add")
    public String showFormForAdd(Model theModel) {

         Employee theEmployee = new Employee();

         theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    //mapping for save employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
    	
         employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int theId, Model theModel) {

        Employee theEmployee = employeeService.findById(theId);
        
        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }
    
    @GetMapping("/delete")
    public String deleteById(@RequestParam("employeeId") int theId) {
    	
    	employeeService.deleteById(theId);
    	
    	return "redirect:/employees/list";
    }

}



























