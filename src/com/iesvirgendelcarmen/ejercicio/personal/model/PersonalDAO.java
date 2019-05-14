package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;


public interface PersonalDAO {
	
	DateTimeFormatter FORMATTER1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	//2019-05-13 09:12:03
	DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");

	List<Student> getStudents();
	List<PrincipalTeacher> getPrincipalTeachers();
	List<SubstituteTeacher> getSubstituteTeachers();
	boolean deletePerson(Person person);
//	Student getStudentsByEmail(String email);
//	PrincipalTeacher getPrincipalTeachersByEmail(String email);
//	SubstituteTeacher getSubstituteTeachersByEmail(String email);
	Person getPersonByEmail(Person person);
	Set<Person> getDeletePerson();
	
}
