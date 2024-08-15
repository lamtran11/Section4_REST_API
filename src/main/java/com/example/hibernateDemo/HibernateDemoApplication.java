

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
			
			createMultipleStudent(studentDAO);
			
		};		
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























