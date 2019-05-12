package com.okaplan.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okaplan.Exception.StudentNotFoundException;
import com.okaplan.demo.Entity.Student;
import com.okaplan.demo.Entity.StudentErrorResponse;

@RestController
@RequestMapping("/api")
public class RestDemoController {
	
	private List<Student> _Students;
	
	@GetMapping("/students") 
	public List<Student> getStudents() {
		return _Students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if( (studentId > _Students.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Such a student not exist");
		}
		return _Students.get(studentId);
		
	}
	@PostConstruct
	public void populateList(){
		_Students=new ArrayList<>();	
		_Students.add(new Student("Osman", "Kaplan"));
		_Students.add(new Student("Oktay", "Kaplan"));
		_Students.add(new Student("Gizem", "Kaplan"));
		_Students.add(new Student("Esra", "Kaplan"));
	}
}
