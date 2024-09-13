package com.example.springCrudDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springCrudDemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>  {
    // Additional methods can be added here if needed.

	
}
