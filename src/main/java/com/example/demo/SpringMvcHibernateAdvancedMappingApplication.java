package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.entity.Review;
import com.example.demo.entity.Student;

@SpringBootApplication
public class SpringMvcHibernateAdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcHibernateAdvancedMappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner (AppDAO appDAO) {
		
		return runner -> 
		
//		createInstructor(appDAO);
		
//		findInstructor(appDAO);
		
//		deleteInstructor(appDAO);
		
//		findInstructorById(appDAO);

//		deleteInstructorDetail(appDAO);
		
//		createInstructorWithCourses(appDAO);
		
//		findInstructorWithCourses(appDAO);
		
//		findCoursesForInstructor(appDAO);
		
//		findInstuctorByIdJoinFetch(appDAO);
		
//		updateInstructor(appDAO);
		
//		updateCourse(appDAO);
		
		//oneToMany
//		deleteInstructorById(appDAO);
		
//		deleteCourseById(appDAO);
		
		
		//OneToMany - Uni-directional
//		createCourseAndReviews(appDAO);
		
//		getCourseAndReviews(appDAO);
	
//		deleteCourseAndReviews(appDAO);
		
	
		//Many to many
		
//		createCourseAndStudents(appDAO);
		
//		findCourseAndItsStudent(appDAO);
		
//		findStudentAndCourses(appDAO);
		
//		addMoreCoursesForStudent(appDAO);
		
//		deleteCourseById(appDAO);
		
		deleteStudentById(appDAO);

	}

	private void deleteStudentById(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		
		int theId = 4;
		
		appDAO.deleteStudentById(theId);
		
		System.out.println("Student deleted with id: " + theId);
		
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("Adding more courses to student ....");
		
		int theId = 1;
		
		
        Student student = appDAO.findStudentById(theId);
        
		System.out.println("studentID ...." + student);

        
        Course course1 = new Course("Spring Security");
        Course course2 = new Course("React JS");
        
        student.addCourse(course1);
        student.addCourse(course2);
        
        appDAO.update(student);
        
        System.out.println("Done adding more courses to student");
        
        
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId = 1;
		
		System.out.println("Get student and its courses.......");
		
		Student student = appDAO.findStudentAndCoures(theId);
		
		System.out.println("Student: " + student);
		
		System.out.println("Courses: " + student.getCourses());
		
		System.out.println("Done !!!!!!");
		
	}

	private void findCourseAndItsStudent(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		int theId = 18;
		
		System.out.println("Get course and its student.......");
		
        Course course = appDAO.findCourseAndStudentByCourseId(theId);
        
        System.out.println("Course: " + course);
        
        System.out.println("Students: " + course.getStudents());
        
        System.out.println("Done !!!!!!");
		

	}

	private void createCourseAndStudents(AppDAO appDAO) {
		
		System.out.println("Creating the course and students .......");
		
		//create the course
		Course tempCourse = new Course("Spring Rest API");
		
		//create students
		Student tempStudent1 = new Student("Tanaka", "Ichiro", "tanaka@gmail.com");
		Student tempStudent2 = new Student("Muichiro", "Tokitou", "muichoro@gmail.com");
		Student tempStudent3 = new Student("Mitsuji", "Kanagawa", "mitsuji@gmail.com");

		//add student to course
		tempCourse.addStudent(tempStudent1);
        tempCourse.addStudent(tempStudent2);
        tempCourse.addStudent(tempStudent3);
		
		//save the course and assocaited students
		appDAO.save(tempCourse);
		
		System.out.println("Course and students saved successfully!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		
		int theId = 2;
		
		System.out.println("Deleting the course with it reveiw");
		
        appDAO.deleteCourseWithReviewsByCourseId(theId);

        System.out.println("Course and reviews deleted successfully!");
	}

	private void getCourseAndReviews(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		
		int theId = 4;
		
		System.out.println("Finding course and it reviews.... " + theId);
		
		Course course = appDAO.findCourseAndReviewsByCourseId(theId);
		
		System.out.println("Course: " + course);
		
		for (Review review : course.getReviews()) {
            System.out.println("Review: " + review);
        }
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("PHP");
		
		tempCourse.addReview(new Review("This course is awesome!"));
		tempCourse.addReview(new Review("This course is incredibly informative and engaging!"));
		tempCourse.addReview(new Review("I learned so much; the material was presented clearly and thoughtfully."));
		tempCourse.addReview(new Review("Excellent course! The examples really helped me understand the concepts."));
		tempCourse.addReview(new Review("Highly recommended! The instructor is knowledgeable and approachable."));
		
		System.out.println("Saving the course........");
		
		appDAO.save(tempCourse);
	}

	private void deleteCourseById(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		int theId = 15;
		
		System.out.println("Deleting course id: " + theId + ".....");
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("Course deleted successfully!");
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId = 3;
		
        System.out.println("Deleting instructor id: " + theId + ".....");
        
        appDAO.deleteInstructorById(theId);
        
        System.out.println("Instructor deleted successfully!");
	}

	private void updateCourse(AppDAO appDAO) {
		//TODO 自動生成されたメソッド・スタブ
		int theId = 25;
		
		System.out.println("Finding course id: " + theId + ".....");
        Course tempCourse = appDAO.findCourseById(theId);
        
        if(tempCourse!= null) {
                
            System.out.println("Updating course details..." + theId);
            
            tempCourse.setTitle("C#");
            
            appDAO.update(tempCourse);
            
            System.out.println("Course updated successfully!");
            
        } else {
            System.out.println("Course not found with id: " + theId);
        }
	}

	private void updateInstructor(AppDAO appDAO) {
		
		int theId = 1;
		
		System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        
        if(tempInstructor!= null) {
        		
            System.out.println("Updating instructor details..." + theId);
            
            tempInstructor.setFirstName("Muichiro");
            
            appDAO.update(tempInstructor);
            
            System.out.println("Instructor updated successfully!");
            
        } else {
        	System.out.println("Instructor not found with id: " + theId);
        }
		
	}

	private void findInstuctorByIdJoinFetch(AppDAO appDAO) {
		
		int theId  = 1;
		
		System.out.println("Finding instructor id: " + theId);
		
        Instructor tempInstructor = appDAO.findInstuctorByIdJoinFetch(theId);
        
        System.out.println("tempInstructor: " + tempInstructor);
        
        //find courses for the instructor
        System.out.println("Find courses for the instructor");   
        System.out.println("Course: " + tempInstructor.getCourses());
        
        System.out.println("Done!!!!");
        
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId  = 1;
		
		System.out.println("Finding instructor id: " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		
		//find courses for the instructor
		System.out.println("Find courses for the instructor");
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		
		tempInstructor.setCourses(courses);
		
        System.out.println("Course: " + tempInstructor.getCourses());
        
		System.out.println("Done with courses");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		int theId  = 1;
		
		System.out.println("Finding instructor id: " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associate course: " + tempInstructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		
		Instructor tempInstructor = new 
				Instructor("takuto", "hayashi", "takuto@gmail.com");
		
		InstructorDetail theInstructDetail = new 
				InstructorDetail("https://www.javatpoint.com/java-tutorial"
                                                        , "Learning Piano");
		
		tempInstructor.setInstructorDetail(theInstructDetail);
		
		Course tempCourse1 = new Course("Japanese");
		Course tempCourse2 = new Course("Maththematic");
		Course tempCourse3 = new Course("Java");
		
		 tempInstructor.add(tempCourse1);
		 tempInstructor.add(tempCourse2);
		 tempInstructor.add(tempCourse3);
		 
		 
		 System.out.println("Saving instructors " + tempInstructor);
		 System.out.println("The courses: " + tempInstructor.getCourses());
		 appDAO.save(tempInstructor);
	
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 4;
//		System.out.println("Deleting " + theId);

		appDAO.deleteInstructorDetailById(theId);

	}

	//bi-directional mapping
	private void findInstructorById(AppDAO appDAO) {
		
		int theId = 7;
		
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		System.out.println("Found Instructor: " + tempInstructorDetail);
		
		System.out.print("Associate Instructor: " + tempInstructorDetail.getInstructor());
	}

	//unidirectional mapping
	private void deleteInstructor(AppDAO appDAO) {
		int theId = 3;

		System.out.println("Deleting " + theId);
		
		appDAO.deleteInstructor(theId);
		
		System.out.println("Deleted!");
	}

	//unidirectional mapping
	private void findInstructor(AppDAO appDAO) {
		
		int theId = 4;
		
		Instructor theInstructor = appDAO.findInstructorById(theId);
		
		if (appDAO.findInstructorById(theId) != null) {
			System.out.println("Found Instructor: " + theInstructor);
			
		} else {
			System.out.println("Instructor not found");
		}
		
	}

	private void createInstructor(AppDAO appDAO) {
		
//		Instructor tempInstructor = new Instructor("hayashi", "tran", "123@gmail.com");
//		
//		InstructorDetail theInstructDetail = new InstructorDetail("https://www.geeksforgeeks.org/cascade-in-sql/"
//																	, "Learning Japanese");
		
		Instructor tempInstructor = new Instructor("miyu", "nagano", "nagano@gmail.com");
		
		InstructorDetail theInstructDetail = new InstructorDetail("https://github.com/darbyluv2code/spring-boot-3-spring-6-hibernate-for-beginners"
																	, "Learning English");
				
		//associate the objects
		tempInstructor.setInstructorDetail(theInstructDetail);
        	
        //save the instructor 
        System.out.println("Saved instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        
        System.out.println("Done!");
	}
}







