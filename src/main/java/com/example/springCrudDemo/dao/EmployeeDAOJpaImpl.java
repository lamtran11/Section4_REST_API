package com.example.springCrudDemo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springCrudDemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //define fields for entity manager
    private EntityManager entityManager;

    //Set constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result
        List<Employee> employees = theQuery.getResultList();

        //return the list
        return employees;
    }

    @Override
    public Employee findById(int theId) {
    	
    	//Get employee 
//    	TypedQuery<Employee> theQuery = entityManager.createQuery("SELECT ",Employee.class);
    	Employee theEmployee = entityManager.find(Employee.class, theId);
    	
    	//return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
    	//save the employee
    	Employee dbEmployee = entityManager.merge(theEmployee);
    	
    	//return the db employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
    	//Find employee by id
    	Employee deleteEmployee = entityManager.find(Employee.class, theId);
    	
    	//Delete employee by id
    	entityManager.remove(deleteEmployee);
    }
}



























