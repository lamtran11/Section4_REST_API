

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.hibernateDemo.Entity.Student;
import com.example.hibernateDemo.dao.StudentDAO;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return runner -> {
			
//			createStudent(studentDAO);
			
//			createMultipleStudent(studentDAO);
			
			readStudent(studentDAO);
			
		};		
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























