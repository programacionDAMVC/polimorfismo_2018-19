package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.util.Objects;

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

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		return result;
		return Objects.hashCode(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
//		if (email == null) {
//			if (other.email != null)
//				return false;
//		} else if (!email.equals(other.email))
//			return false;
//		return true;
		return Objects.equals(this.email, other.email);
	}
	
	
	
}
