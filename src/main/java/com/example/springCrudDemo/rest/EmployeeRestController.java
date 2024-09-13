package com.example.springCrudDemo.rest;

import com.example.springCrudDemo.entity.Employee;
import com.example.springCrudDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


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
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
    
    
    //add mapping for get single employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
    	
    	Employee theEmployee = employeeService.findById(employeeId);
    	
    	if (theEmployee == null) {
    		throw new RuntimeException("Employee not found - " + employeeId); 
    	}
    	return theEmployee;
    }
    
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
    	//phòng trừ case pass id qua JSON thì nên setID thành 0
    	//này cũng tương đương ép buộc tạo mới, thay vì update (vì nếu pass nhầm id tồn tại thành ra sửa)
    	theEmployee.setId(0);
    	
    	Employee dbEmployee = employeeService.save(theEmployee);
    	
    	return dbEmployee;
    }

    
    @PutMapping("/employees")
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



























