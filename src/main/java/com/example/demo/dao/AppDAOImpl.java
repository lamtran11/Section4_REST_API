package com.example.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;

@Repository
public class AppDAOImpl implements AppDAO {

	private EntityManager entityManager;
	
	@Autowired
	public AppDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
	
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}


	@Override
	public Instructor findInstructorById(int id) {
		
		return entityManager.find(Instructor.class, id);
		
	}


	@Override
	@Transactional
	public void deleteInstructor(int id) {
		
		Instructor tempInstructor = entityManager.find(Instructor.class, id);
		
		if(tempInstructor != null) {
            entityManager.remove(tempInstructor);
        } else {
        	System.out.println("Instructor not found for delete with id: " + id);
        }
		
	}
	
}
















