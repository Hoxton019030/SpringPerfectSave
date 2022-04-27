package com.jerrymvc.springdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "studentname")
	private String studentName;

	@Column(name = "grade")
	private String grade;

	@Column(name = "notes")
	private String notes;

	public Students() {
	}

	public Students(int id, String studentName, String grade, String notes) {
		this.id = id;
		this.studentName = studentName;
		this.grade = grade;
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", studentName=" + studentName + ", grade=" + grade + ", notes=" + notes + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

}
