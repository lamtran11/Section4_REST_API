package com.example.springCrudDemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springCrudDemo.entity.Employee;
import com.example.springCrudDemo.service.EmployeeService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://127.0.0.1:5500")
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
    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    
    
    //add mapping for get single employee
    @GetMapping("/findById/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
    	
    	Employee theEmployee = employeeService.findById(employeeId);
    	
    	if (theEmployee == null) {
    		throw new RuntimeException("Employee not found - " + employeeId); 
    	}
    	return theEmployee;
    }
    
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
    	//phòng trừ case pass id qua JSON thì nên setID thành 0
    	//này cũng tương đương ép buộc tạo mới, thay vì update (vì nếu pass nhầm id tồn tại thành ra sửa)
    	theEmployee.setId(0);
    	
    	Employee dbEmployee = employeeService.save(theEmployee);
    	
    	return dbEmployee;
    }

    
    @PutMapping("/save")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
    	
    	Employee updateEmployee = employeeService.save(theEmployee);
    	return updateEmployee;
    }

    
    @DeleteMapping("/delete/{employeeId}")
    public String deleteEmployee (@PathVariable int employeeId) {
    	
    	//Take employeeId want to delete
        Employee deleteEmployee = employeeService.findById(employeeId);
        
        
        if(deleteEmployee == null) {
        	throw new RuntimeException("Employee not found - " + employeeId);
        }
        
        //Delete employee
        employeeService.deleteById(employeeId);

        return "Delete employee id - " + employeeId;
    }
}



























