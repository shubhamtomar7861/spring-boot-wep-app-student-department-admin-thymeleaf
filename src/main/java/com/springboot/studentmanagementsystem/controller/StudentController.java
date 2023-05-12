package com.springboot.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springboot.studentmanagementsystem.entity.Student;
import com.springboot.studentmanagementsystem.service.StudentServices;



@Controller
public class StudentController {

	private StudentServices studentServices;

	public StudentController(StudentServices studentServices) {
		super();
		this.studentServices = studentServices;
	}
	
	
	// handller method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentServices.getAllStudents());
		
		return "students";
		
	}
	
	@GetMapping("/students/new")
	public String createStudentFrom(Model model) {
		
		// create student object to hold student form data
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentServices.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		
		model.addAttribute("student", studentServices.getStudentById(id));
		return "edit_student";
		
	}
	
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,
			Model model) {
		
		
		// get student from database by id
		Student existingStudent = studentServices.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		
		// save updated student object
		studentServices.updateStudent(existingStudent);
		return "redirect:/students";
		
		
		
	}
	
	
	
	
	// handler method to delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		
		
		
		studentServices.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
	
}
