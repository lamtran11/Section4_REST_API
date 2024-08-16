package com.example.hibernateDemo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.hibernateDemo.entity.Student;

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

	//This is method
	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		//Create query
		TypedQuery<Student> theQuery = entityManager.createQuery(
							"FROM Student", Student.class);	
		
		//return the list of students
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		//1. Create query
		TypedQuery<Student> theQuery = entityManager.createQuery(
							"FROM Student WHERE lastName=:theData", Student.class);
		// :=theData : Placeholder that is filled in later
		
		
		//2. Set query parameters
		theQuery.setParameter("theData", lastName);
		
		
		//3. Execute query and return the result list
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// Retriev the student
		Student theStudent = entityManager.find(Student.class, id);
		
		//delete student
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		
		return numRowsDeleted;
	}
}

























