package com.example.hibernateDemo.dao;

import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernateDemo.Entity.Student;

//Sub-annotation of @Component. Component: RestController, Repository
//Give support fot component scaninng, translating JDBC exceptions
@Repository
public class StudentDAOlmpl implements StudentDAO {
	// define fields for entity manager
	private EntityManager entityManager;
	
	
	//inject the entity manager using constructor injection
	//Autowired is optional when we only have one constructor => But still write improve follow
	@Autowired
	public StudentDAOlmpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	//
	@Override
	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}
	
	@Override
    public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
}


















