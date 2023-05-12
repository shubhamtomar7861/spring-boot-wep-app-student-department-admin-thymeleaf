package com.springboot.studentmanagementsystem.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.studentmanagementsystem.entity.Student;
import com.springboot.studentmanagementsystem.repository.StudentRepository;
import com.springboot.studentmanagementsystem.service.StudentServices;

@Service
public class StudentServiceImpl implements StudentServices {

	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		
		
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		
		
		return studentRepository.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
		
	}
	
	

}
