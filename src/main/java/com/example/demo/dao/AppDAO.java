package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Student;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructor(int id);
	
	InstructorDetail findInstructorDetailById(int id);

	void deleteInstructorDetailById(int id);
	
	
	//
	
	List<Course> findCoursesByInstructorId(int id);
	
	Instructor findInstuctorByIdJoinFetch(int id);
	
	void update(Instructor instructor);

	void update(Course course);
	
	Course findCourseById(int theId);
	
	void deleteInstructorById(int theId);
	
	void deleteCourseById(int theId);
	
	void save(Course course);
	
	Course findCourseAndReviewsByCourseId(int theId);
	
	void deleteCourseWithReviewsByCourseId(int theId);
	
	
	//Many to Many
	Course findCourseAndStudentByCourseId(int theId);
	
	Student findStudentAndCoures(int theId);
	
	void update(Student theStudent);
	
	Student findStudentById(int theId);
	
	void deleteStudentById(int theId);
	
	
}









