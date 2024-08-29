package com.example.springCrudDemo.service;

import com.example.springCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    Employee update(int theId);

    void deleteById(int theId);
}
