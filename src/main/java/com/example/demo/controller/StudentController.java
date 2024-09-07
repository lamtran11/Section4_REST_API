package com.example.demo.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
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
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	private StudentService studentService;

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

	@GetMapping("/findById")
	public String getStudentById(@RequestParam("studentId") int theId, Model theModel) {

		Student theStudent = studentService.findById(theId);

		theModel.addAttribute("student", theStudent);

		return "student/student-profile";

	}


	@GetMapping("/students/studentList")
	public String getStudents(@RequestParam(defaultValue = "0") int page, 
	                          @RequestParam(defaultValue = "10") int size, 
	                          Model model) {
		
	    Page<Student> studentPage = studentService.findPaginated(page, size);
	    model.addAttribute("students", studentPage.getContent());
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", studentPage.getTotalPages());
	    return "students";
	}


}
