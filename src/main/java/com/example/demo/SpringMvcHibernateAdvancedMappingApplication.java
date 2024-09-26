package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

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
		
		findInstructorWithCourses(appDAO);

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		int theId  = 1;
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Associate course: " + tempInstructor.getCourse());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// TODO 自動生成されたメソッド・スタブ
		
		Instructor tempInstructor = new Instructor("takuto", "hayashi", "takuto@gmail.com");
		
		InstructorDetail theInstructDetail = new InstructorDetail("https://www.javatpoint.com/java-tutorial"
                                                        , "Learning Piano");
		
		tempInstructor.setInstructorDetail(theInstructDetail);
		
		Course tempCourse1 = new Course("Japanese");
		Course tempCourse2 = new Course("Maththematic");
		Course tempCourse3 = new Course("Java");
		
		 tempInstructor.add(tempCourse1);
		 tempInstructor.add(tempCourse2);
		 tempInstructor.add(tempCourse3);
		 
		 
		 System.out.println("Saving instructors " + tempInstructor);
		 System.out.println("The courses: " + tempInstructor.getCourse());
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
