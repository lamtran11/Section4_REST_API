package com.example.hibernateDemo;


import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hibernateDemo.dao.StudentDAO;
import com.example.hibernateDemo.entity.Student;

@SpringBootApplication
public class HibernateDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner -> {
			
//			createStudent(studentDAO);
			
			createMultipleStudent(studentDAO);
			
//			readStudent(studentDAO);
			
//			queryForStudent(studentDAO);
			
//			searchStudentByLastName(studentDAO);
			
//			updateStudent(studentDAO);
			
//			deleteStudent(studentDAO);
			
//			deleteAll(studentDAO);
			
			
			
		};		
	}

	private void deleteAll(StudentDAO studentDAO) {
		 
         System.out.println("All students deleted");
         
         int numRowsDeleted = studentDAO.deleteAll();
         
         System.out.println("Number of rows deleted: " + numRowsDeleted);
	}


	private void deleteStudent(StudentDAO studentDAO) {
		//1. Retrieve student based on the id
		int studentId = 3;
		System.out.println("Delete student by id " + studentId);
		
		//2. Delete retrieved student with id
		studentDAO.delete(studentId);
        
        //3. Display the deleted student
        System.out.println("Deleted student: " + studentId);
	}


	private void updateStudent(StudentDAO studentDAO) {
		//1. Retrieve student based on the id
		int studentId = 1;
		System.out.println("Getting student by id " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		//2. Change first name to Tanaka
		System.out.println("Changing first name.....");
		myStudent.setFirstName("Tanaka");
		
		//3. Update the student
		studentDAO.update(myStudent);
		
		//4.Display the updated student
		System.out.println("Updated student: " + myStudent);		
	}


	private void searchStudentByLastName(StudentDAO studentDAO) {
		//1. Take the last name from database
		List<Student> students = studentDAO.findByLastName("Inage");
		
		///2. Display list of students		
		for (Student student : students) {			
            System.out.println("Student with last name: " + student);
		}
	}


	private void queryForStudent(StudentDAO studentDAO) {
		
		//1. Take data from database
		List<Student> students = studentDAO.findAll();
		
		//2. Display all student
		for(Student student : students) {
			
			System.out.println("Student: " + student);
			
		}	
	}

	private void readStudent(StudentDAO studentDAO) {
		// 1.Create a student object
		System.out.println("Creating new student object.....");
		Student tempStudent = new Student("John", "Doe", "john@gmail.com");
		
		//Save the student
		System.out.println("Saving the student........");
		studentDAO.save(tempStudent);
		
		
		//Display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);
		
		
		//Retrive student based on the id: primary key
		System.out.println("Retrieving student with primary key: " + theId);
		Student foundStudent = studentDAO.findById(theId);
		
		
		//Display student
		System.out.println("Found student: " + foundStudent);		
	}


	private void createMultipleStudent(StudentDAO studentDAO) {
		//1. Create student object
		System.out.println("Creating 3 student object ................");
		Student tempStudent1 = new Student("Masato", "Ichiro", "masato@gmail.com");
		Student tempStudent2 = new Student("Takuto", "Inage", "takuto@gmail.com");
		Student tempStudent3 = new Student("Yamada", "Chihiro", "chihiro@gmail.com");
		
		
		//2. Save student object to the database
		System.out.println("Saving student objects");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	
	}


	private void createStudent(StudentDAO studentDAO) {
		// TODO 自動生成されたメソッド・スタブ
		//1. Create student object
		System.out.println("Creating student object ................");
		Student tempStudent = new Student("Yukiko", "Miwako", "yukikojapan@gmail.com");
		
		
		//2. Save student object to the database
		System.out.println("Saving student object ................");
		studentDAO.save(tempStudent);
		
		//3. Display ID of the saved student 
		System.out.println("Saved student ID : " + tempStudent.getId());
	}

}























