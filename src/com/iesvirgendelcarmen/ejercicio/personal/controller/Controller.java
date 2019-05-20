package com.iesvirgendelcarmen.ejercicio.personal.controller;

import java.util.List;

import com.iesvirgendelcarmen.ejercicio.personal.model.DeletePerson;
import com.iesvirgendelcarmen.ejercicio.personal.model.Person;
import com.iesvirgendelcarmen.ejercicio.personal.model.PersonalDAO;
import com.iesvirgendelcarmen.ejercicio.personal.model.PersonalDAORelational;
import com.iesvirgendelcarmen.ejercicio.personal.model.Student;
import com.iesvirgendelcarmen.ejercicio.personal.view.View;

public class Controller {
	
	PersonalDAO pdDao;
	View view;
	
	public Controller(View view) {
		this.view = view;
		this.pdDao = new PersonalDAORelational();
	}
	
//	public List<Person> getListStudents(){
//		return pdDao.getStudents();
//	}
//	
//	public List<Person> getListPersonDelete(){
//		return pdDao.getDeletePerson();				
//	}
	public List<Person> getListPeople(String type){
		switch (type) {
		case "deletePerson":
			return pdDao.getListPeople("deletePerson");
		case "principalTeacher":
			return pdDao.getListPeople("principalTeacher");
		case "substituteTeacher":
			return pdDao.getListPeople("substituteTeacher");
		case "student":
			return pdDao.getListPeople("student");
		default:
			return null;
		}
	}
}
