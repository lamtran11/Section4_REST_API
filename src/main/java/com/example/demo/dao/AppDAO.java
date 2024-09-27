package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

public interface AppDAO {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructor(int id);
	
	InstructorDetail findInstructorDetailById(int id);

	void deleteInstructorDetailById(int id);
	
	List<Course> findCoursesByInstructorId(int id);
	
	Instructor findInstuctorByIdJoinFetch(int id);
	
	void update(Instructor instructor);

	void update(Course course);
	
	Course findCourseById(int theId);
	
	void deleteInstructorById(int theId);
}
