package com.example.springCrudDemo.dao;

import com.example.springCrudDemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        return null;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return null;
    }

    @Override
    public void deleteById(int theId) {

    }
}
