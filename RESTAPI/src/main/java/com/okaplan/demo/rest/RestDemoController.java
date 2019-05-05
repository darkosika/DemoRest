package com.okaplan.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.okaplan.demo.Entity.Student;

@RestController
@RequestMapping("/api")
public class RestDemoController {
	
	@GetMapping("/students") 
	public List<Student> getStudents() {
		List<Student> _Students=new ArrayList<>();
		_Students.add(new Student("Osman", "Kaplan"));
		_Students.add(new Student("Oktay", "Kaplan"));
		_Students.add(new Student("Gizem", "Kaplan"));
		_Students.add(new Student("Esra", "Kaplan"));
		
		return _Students;
	}
}
