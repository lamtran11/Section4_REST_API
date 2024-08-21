package com.example.springCrudDemo.dao;

import com.example.springCrudDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>  {
    // Additional methods can be added here if needed.


}
