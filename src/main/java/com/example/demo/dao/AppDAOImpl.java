package com.example.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

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


	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		
		return entityManager.find(InstructorDetail.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {

		//retrieve instructor in dbs
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);

		//remove associated object reference
		//break bi-directional link
		tempInstructorDetail.getInstructor().setInstructorDetail(null);


		//remove by id
		//Này setup cascade rồi so it will delete in both tables
		if(tempInstructorDetail != null) {
            entityManager.remove(tempInstructorDetail);
			System.out.println("Instructor Detail deleted successfully with id: " + id);
        } else {
            System.out.println("Instructor Detail not found for delete with id: " + id);
        }
	}

}
















