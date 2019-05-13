package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.util.List;


public interface PersonalDAO {
	List<Student> getStudents();
	List<PrincipalTeacher> getPrincipalTeachers();
	List<SubstituteTeacher> getSubstituteTeachers();
	boolean deletePerson(Person person);
//	Student getStudentsByEmail(String email);
//	PrincipalTeacher getPrincipalTeachersByEmail(String email);
//	SubstituteTeacher getSubstituteTeachersByEmail(String email);
	Person getPersonByEmail(Person person);
	List<Person> getDeletePerson();
	
}
