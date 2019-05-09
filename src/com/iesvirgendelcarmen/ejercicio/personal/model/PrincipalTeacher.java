package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.time.LocalDate;

public class PrincipalTeacher extends Teacher {
	/*dicarlo9@phoca.cz,2005/01/10
elaurenza@mapquest.com,2005/01/11
	 */
	private LocalDate contract;

	public PrincipalTeacher(String firstName, String lastName, String email, Gender gender, String subject,
			LocalDate contract) {
		super(firstName, lastName, email, gender, subject);
		this.contract = contract;
	}

	public LocalDate getContract() {
		return contract;
	}

	public void setContract(LocalDate contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return String.format("PrincipalTeacher [contract=%s]", contract);
	}
	
}
