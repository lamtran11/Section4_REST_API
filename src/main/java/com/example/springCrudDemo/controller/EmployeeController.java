package com.example.springCrudDemo.controller;

import com.example.springCrudDemo.entity.Employee;
import com.example.springCrudDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String saveEmployee(Employee theEmployee) {
         employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @PutMapping("/update")
    public String updateEmployee(@ModelAttribute("employee") Employee theEmployee) {

         employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

}



























