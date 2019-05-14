package com.iesvirgendelcarmen.ejercicio.personal.model;

public class Teacher extends Person{
	public Teacher(String firstName, String lastName, String email, Gender gender, String subject) {
		super(firstName, lastName, email, gender);
		this.subject = subject;
	}

	private String subject;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return String.format("Teacher [subject=%s], %S", subject, super.toString());
	}
	
	
	
}
