package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dao.AppDAO;
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
		
		deleteInstructor(appDAO);
		
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 3;

		System.out.println("Deleting " + theId);
		
		appDAO.deleteInstructor(theId);
		
		System.out.println("Deleted!");
	}

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
