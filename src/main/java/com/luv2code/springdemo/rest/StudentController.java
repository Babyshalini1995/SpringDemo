package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> theStudents;
	
	//define @poset condtruct to load data only once..
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Baby","Shalini"));
		theStudents.add(new Student("Sindhu","Kumarasamy"));
	}
	
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//just index into list
		
		//check studeentid against list size
		if((studentId >= theStudents.size()) || (studentId<0)) {
			throw new StudentNotFoundException("Student Id not found - "+ studentId);
		}
		
		
		return theStudents.get(studentId);
	}
	
	
}
