package com.example.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentRepository.findById(theId);

		Student theStudent = null;

		if (result.isPresent()) {
			theStudent = result.get();
		} else {
			throw new RuntimeException("The Student does not exist");
		}
		return theStudent;
	}

	@Override
	public Student save(Student theStudent) {

		return studentRepository.save(theStudent);
	}
	
//	@Override
//	public List<Student> saveAll(List<Student> students) {
//		// TODO 自動生成されたメソッド・スタブ
//		return studentRepository.saveAll(students);
//	}

	@Override
	public Student update(Student student) {

		Optional<Student> result = studentRepository.
									findById(student.getId());

		Student theStudent = null;

		if (result.isPresent()) {
			theStudent = result.get();

		} else {
			throw new RuntimeException("The Student does not exist - " 
					+ student.getId());
		}

		return theStudent;
	}

	@Override
	public void deleteById(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		studentRepository.deleteById(theId);

	}

	@Override
	public boolean emailExists(String email) {
		// TODO 自動生成されたメソッド・スタブ
		return studentRepository.existsByEmail(email);
	}
	

	@Override
	public void deleteByIds(List<Integer> studentIds) {
        studentRepository.deleteAllById(studentIds);
    }

//	@Override
//	public Iterable<Student> getAllStudents(Integer pageSize, Integer offset) {
//		// TODO 自動生成されたメソッド・スタブ
//		return studentRepository.findAll(PageRequest.of(offset, pageSize));
//	}


//	@Override
//	public Student getStudentByEmail(Student student) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}

//	@Override
//    public Page<Student> findPaginated(int page, int size) {
//        PageRequest pageable = PageRequest.of(page, size);
//        return studentRepository.findAll(pageable);
//    }

	@Override
    public List<Student> findByLastNameContainingIgnoreCase(String theLastName) {
        // Handle null or empty last name
        if (theLastName == null || theLastName.trim().isEmpty()) {
            return Collections.emptyList(); // or return all students if needed
        }

        return studentRepository.findByLastNameContainingIgnoreCase(theLastName);
    }

    @Override
    public List<Student> findByEmailContainingIgnoreCase(String email) {
        // Handle null or empty email
        if (email == null || email.trim().isEmpty()) {
            return Collections.emptyList(); // or return all students if needed
        }

        return studentRepository.findByEmailContainingIgnoreCase(email);
    }

    @Override
    public List<Student> findByLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String lastName, String email) {
        // Handle null or empty last name and email
        if ((lastName == null || lastName.trim().isEmpty()) &&
            (email == null || email.trim().isEmpty())) {
            return Collections.emptyList(); // or return all students if needed
        }

        return studentRepository.findByLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(lastName, email);
    }

    	
	
}


















