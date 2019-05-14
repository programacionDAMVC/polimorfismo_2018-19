package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.time.LocalDateTime;

public class DeletePerson extends Person {
	
	private LocalDateTime deleteDate;

	public DeletePerson(String firstName, String lastName, String email, Gender gender, LocalDateTime deleteDate) {
		super(firstName, lastName, email, gender);
		this.deleteDate = deleteDate;
	}

	public LocalDateTime getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(LocalDateTime deleteDate) {
		this.deleteDate = deleteDate;
	}

	@Override
	public String toString() {
		return String.format("DeletePerson [deleteDate=%s], %S", deleteDate, super.toString());
	}
	
}
