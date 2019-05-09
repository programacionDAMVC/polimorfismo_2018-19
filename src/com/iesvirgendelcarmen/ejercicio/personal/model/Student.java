package com.iesvirgendelcarmen.ejercicio.personal.model;

public class Student extends Person{
	private String course;

	public Student(String firstName, String lastName, String email, Gender gender, String course) {
		super(firstName, lastName, email, gender);
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return String.format("Student [course=%s] %s", course);
	}
	
}
