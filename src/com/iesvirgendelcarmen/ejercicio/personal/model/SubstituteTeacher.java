package com.iesvirgendelcarmen.ejercicio.personal.model;

public class SubstituteTeacher extends Teacher{
	private int career;

	public SubstituteTeacher(String firstName, String lastName, String email, Gender gender, String subject,
			int career) {
		super(firstName, lastName, email, gender, subject);
		this.career = career;
	}

	public int getCareer() {
		return career;
	}

	public void setCareer(int career) {
		this.career = career;
	}

	@Override
	public String toString() {
		return String.format("SubstituteTeacher [career=%s]", career);
	}
	
}
