package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Student;
import com.example.demo.service.PdfService;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	 @Autowired
	 private PdfService pdfService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	//Add init binder to trim space
	//Remove white space 
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

	}

	@GetMapping("/studentList")
	public String getStudentList(Model theModel) {

		List<Student> studentList = studentService.findAll();

		theModel.addAttribute("student", studentList);

		return "student/studentList";
	}

	@GetMapping("/filterStudents")
	public String getStudentList(
		    @RequestParam(defaultValue = "") String lastName,
		    @RequestParam(defaultValue = "") String email,
		    Model theModel) {

		    // Call the service to get the filtered list based on the search criteria
		    List<Student> studentList = studentService.findByLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(lastName, email);

		    // Add the attributes to the model
		    theModel.addAttribute("students", studentList);
		    theModel.addAttribute("searchLastName", lastName);
		    theModel.addAttribute("searchEmail", email);

		    return "student/studentList";
		}
	//	
	//	@GetMapping("/studentList")
	//	public String getStudentList(Model theModel, 
	//	                             @RequestParam(defaultValue = "0") int page, 
	//	                             @RequestParam(defaultValue = "10") int size) {
	//
	//	    // Fetching the paginated students list
	//	    Page<Student> studentPage = studentService.findPaginated(page, size);
	//	    
	//	    // Get the content (list of students) from the paginated result
	//	    List<Student> studentList = studentPage.getContent();
	//	    
	//	    // Add the paginated student list to the model
	//	    theModel.addAttribute("students", studentList);
	//
	//	    // Add pagination attributes to the model
	//	    theModel.addAttribute("currentPage", studentPage.getNumber());
	//	    theModel.addAttribute("totalPages", studentPage.getTotalPages());
	//	    theModel.addAttribute("pageSize", size);
	//
	//	    return "student/studentList";
	//	}

	@GetMapping("/add")
	public String showFormAdd(Model theModel) {

		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "student/student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "student/student-form";
		}

		try {
			studentService.save(theStudent);

		} catch (DataIntegrityViolationException e) {
			// Handle the unique constraint violation
			theBindingResult.rejectValue("email", "error.student.email", "This email is already registered.");
			return "student/student-form";
		}

		return "redirect:/students/studentList";
	}

	@GetMapping("/update")
	public String showFormUpdate(@RequestParam("studentId") int theId, Model theModel) {

		Student theStudent = studentService.findById(theId);

		theModel.addAttribute("student", theStudent);

		return "student/student-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int theId) {

		studentService.deleteById(theId);

		return "redirect:/students/studentList";
	}

	@PostMapping("/deleteSelectedStudents")
	public String deleteSelectedStudents(
			@RequestParam(value = "studentIds", required = false) List<Integer> studentIds,
			Model model) {

		// Handle the case where no checkboxes are selected
		if (studentIds == null || studentIds.isEmpty()) {
			model.addAttribute("errorMessage", "No students selected for deletion.");
			return "student/studentList"; // Ensure this matches your actual view name

		} else {

			studentService.deleteByIds(studentIds);

			model.addAttribute("successMessage", "Selected students have been deleted successfully.");

			return "student/studentList";

		}

	}

	@GetMapping("/getStudentProfile")
	public String getStudentById(@RequestParam("studentId") int theId, Model theModel) {

		Student theStudent = studentService.findById(theId);

		theModel.addAttribute("student", theStudent);

		return "student/student-profile";

	}
	
	@GetMapping("/exportFormStudent")
    public HttpEntity<InputStreamResource> exportStudentToPdf(@RequestParam("studentId") int studentId) throws IOException {
        Student student = studentService.findById(studentId);
        
//        if (student == null) {
//            return new HttpEntity<>(HttpStatus.NOT_FOUND);
//        }

        ByteArrayInputStream bis = pdfService.generateStudentPdf(student);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=student_" + studentId + ".pdf");

        return new HttpEntity<>(new InputStreamResource(bis), headers);
    }

	//	@GetMapping("/students/studentList")
	//	public String getStudents(@RequestParam(defaultValue = "0") int page, 
	//	                          @RequestParam(defaultValue = "10") int size, 
	//	                          Model model) {
	//		
	//	    Page<Student> studentPage = studentService.findPaginated(page, size);
	//	    model.addAttribute("students", studentPage.getContent());
	//	    model.addAttribute("currentPage", page);
	//	    model.addAttribute("totalPages", studentPage.getTotalPages());
	//	    return "students";
	//	}

	//	@PostConstruct
	//	public void createStudents() {
	//		
	//		List<Student> students = new ArrayList<Student>();
	//		
	//		for (int i = 0; i < 100; i++) {
	//			
	//			Student theStudent = new Student();
	//			
	//			theStudent.setId(i);
	//			theStudent.setFirstName("Fristname + " + i);
	//			theStudent.setLastName("Lastname + " + i);
	//			
	//			students.add(theStudent);
	//			
	//		}
	//		studentService.saveAll(students);
	//	}
	//	
	//	@GetMapping("/getAll/{offset}")
	//	public Iterable<Student> getAllStudents(@RequestParam Integer pageSize, @PathVariable("offset") Integer offset) {
	//		
	//		return studentService.getAllStudents(pageSize, offset);
	//	}

}
