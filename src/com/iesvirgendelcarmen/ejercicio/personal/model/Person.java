package com.iesvirgendelcarmen.ejercicio.personal.model;

public class Person {
/*firstName TEXT NOT NULL,
	lastName  TEXT NOT NULL,
	emailPerson TEXT PRIMARY KEY,
	gender    TEXT NOT NULL
*/
	private String firstName;
	private String lastName;
	private String email;
	private Gender gender;
	
	public Person(String firstName, String lastName, String email, Gender gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return String.format("Person [firstName=%s, lastName=%s, email=%s, gender=%s]", firstName, lastName, email,
				gender);
	}
	
	
}
