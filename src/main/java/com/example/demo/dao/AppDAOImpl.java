package com.example.demo.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
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

		if (tempInstructor != null) {
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
		if (tempInstructorDetail != null) {
			entityManager.remove(tempInstructorDetail);
			System.out.println("Instructor Detail deleted successfully with id: " + id);
		} else {
			System.out.println("Instructor Detail not found for delete with id: " + id);
		}
	}

	@Override
	public List<Course> findCoursesByInstructorId(int id) {

		TypedQuery<Course> query = entityManager.createQuery(
				"from Course where instructor.id = :data", Course.class);

		query.setParameter("data", id);

		List<Course> courses = query.getResultList();

		return courses;
	}

	@Override
	public Instructor findInstuctorByIdJoinFetch(int id) {

		//This code will retrieve all Instructor and courses
		TypedQuery<Instructor> query = entityManager.createQuery(
				"SELECT i from Instructor i "

						+ "JOIN FETCH i.course "
						+ "JOIN FETCH i.instructorDetail "
						+ "WHERE i.id = :data",
				Instructor.class);

		query.setParameter("data", id);

		Instructor instructor = query.getSingleResult();

		return instructor;

	}

	@Override
	@Transactional
	public void update(Instructor instructor) {
		// TODO 自動生成されたメソッド・スタブ
		entityManager.merge(instructor);
	}

	@Override
	@Transactional
	public void update(Course course) {
		// TODO 自動生成されたメソッド・スタブ
		entityManager.merge(course);
	}

	@Override
	public Course findCourseById(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {

		//retrieve the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);

		List<Course> courses = tempInstructor.getCourses();

		//remove all associated courses
		//Id not do it => got constraint violation error, phải dùng for each vì có nhiều course
		for (Course course : courses) {
			course.setInstructor(null);
			//            entityManager.remove(course);
		}

		entityManager.remove(tempInstructor);
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		Course tempCourse = entityManager.find(Course.class, theId);

		entityManager.remove(tempCourse);

	}

	@Override
	@Transactional
	public void save(Course course) {

		entityManager.persist(course);

	}
	
//	public Course getCourseWithReviews(int courseId) {
//	    TypedQuery<Course> query = entityManager.createQuery(
//	        "SELECT DISTINCT c FROM Course c " +
//	        "JOIN FETCH c.reviews " +
//	        "WHERE c.id = :data",
//	        Course.class);
//	    
//	    query.setParameter("data", courseId);
//	    return query.getSingleResult(); // Returns the course with its reviews
//	}

	@Override
	public Course findCourseAndReviewsByCourseId(int courseId) {
	    TypedQuery<Course> query = entityManager.createQuery(
	        "SELECT DISTINCT c FROM Course c " +
	        "JOIN FETCH c.reviews " +
	        "WHERE c.id = :data",
	        Course.class);
	    
	    query.setParameter("data", courseId);
	    return query.getSingleResult(); // Returns the course with its reviews
	}

	
}




