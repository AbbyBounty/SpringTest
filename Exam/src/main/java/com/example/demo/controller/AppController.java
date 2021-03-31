package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;

import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/")
public class AppController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

//	------------------------------------------------------------------------------------------
//	-----------------------------------------COURSE-------------------------------------------
//	------------------------------------------------------------------------------------------

//  Add a Course
	@PostMapping("/course/add")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		return new ResponseEntity<>(courseRepository.save(course), HttpStatus.OK);
	}
	
//	Delete a given Course
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable int id) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + id));
		courseRepository.delete(course);

		return new ResponseEntity<>(HttpStatus.OK);
	} 

//	Get a Student’s data for a given Course
	@GetMapping("/course/student")
	public ResponseEntity<Object> getStudentsCourse(@RequestBody Course course ) {
		Course course1 = courseRepository.findByName(course.getName())
				.orElseThrow(() -> new ResourceNotFoundException("Course not exist with id :" + course.getCourse_id()));
		int id =course1.getCourse_id();
		return new ResponseEntity<>(courseRepository.findById(id), HttpStatus.OK);

	}
	
//	------------------------------------------------------------------------------------------
//	-----------------------------------------STUDENT-------------------------------------------
//	------------------------------------------------------------------------------------------

//  Add a Student
	@PostMapping("/student/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
	} 
	
//  Allocate a Student to one or more Course
	@PostMapping("/student/addcourse/{id}")
	public ResponseEntity<Course> addStudentCourse(@PathVariable int id,@RequestBody Course course) {
		
		
		return new ResponseEntity<>(courseRepository.save(course), HttpStatus.OK);
	} 	
	
// List Students
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents() {
		return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
	}
	
	


}
