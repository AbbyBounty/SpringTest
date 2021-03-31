package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course {

	int course_id;
	String name;
	String professor_name;
	String description;
	
	
	private Student student;

	public Course() {
	
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getProfessor_name() {
		return professor_name;
	}

	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="student")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", name=" + name + ", professor_name=" + professor_name
				+ ", description=" + description + ", student=" + student + "]";
	}
	
	
	
}
