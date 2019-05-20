package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;


public interface PersonalDAO {
	
	DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	//2019-05-13 09:12:03
	DateTimeFormatter FORMATTER_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//	List<Student> getStudents();
//	List<PrincipalTeacher> getPrincipalTeachers();
//	List<SubstituteTeacher> getSubstituteTeachers();
	boolean deletePerson(Person person);
//	Student getStudentsByEmail(String email);
//	PrincipalTeacher getPrincipalTeachersByEmail(String email);
//	SubstituteTeacher getSubstituteTeachersByEmail(String email);
	Person getPersonByEmail(Person person);
//	List<DeletePerson> getDeletePerson();
	List<Person> getListPeople(String type);
	
}
