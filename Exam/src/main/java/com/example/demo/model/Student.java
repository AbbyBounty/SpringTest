package com.example.demo.model;

import javax.persistence.*;

import java.util.*;


@Entity
@Table(name="student")
public class Student {

	
	int student_id;
	String name;
	String email;
	String phone;
	
	
	private List<Course> courses = new ArrayList<>();

	public Student() {
	
	}
	
	

	public Student(int student_id, List<Course> courses) {
		super();
		this.student_id = student_id;
		this.courses = courses;
	}



	public Student(int student_id, String name, String email, String phone, List<Course> courses) {
		
		this.student_id = student_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.courses = courses;
	} 



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStudent_id() {
		return student_id;
	}

	@Column
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", courses=" + courses + "]";
	} 
	
	
	
}
