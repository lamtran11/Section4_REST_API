package com.example.springCrudDemo.rest;

import com.example.springCrudDemo.entity.Employee;
import com.example.springCrudDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

//    private EmployeeDAO employeeDao;

//    public EmployeeRestController(EmployeeDAO employeeDao) {
//        this.employeeDao = employeeDao;
//    }
//
//    // expose "/employee" and return a list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll() {
//        return employeeDao.findAll();
//    }
//}


    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
















