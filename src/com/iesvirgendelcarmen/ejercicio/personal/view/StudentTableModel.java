package com.iesvirgendelcarmen.ejercicio.personal.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.iesvirgendelcarmen.ejercicio.personal.model.Person;
import com.iesvirgendelcarmen.ejercicio.personal.model.PersonalDAO;
import com.iesvirgendelcarmen.ejercicio.personal.model.Student;

public class StudentTableModel extends AbstractTableModel{
	//private PersonalDAO pDao;
	private List<Person> listStudent;
	
	
	public StudentTableModel(List<Person> listStudent) {
		//this.pDao = pDao;
		this.listStudent = listStudent;
	}
	private String[] columName = {"First Name", "Last Name", "email", "Gender", "Course"};
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columName.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listStudent.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
		case 0:
			return listStudent.get(arg0).getFirstName();
		case 1:
			return listStudent.get(arg0).getLastName();
		case 2:
			return listStudent.get(arg0).getEmail();
		case 3:
			return listStudent.get(arg0).getGender().toString();
		case 4:
			return ((Student) listStudent.get(arg0)).getCourse();
		default:
			break;
		}
		return null;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columName[column];
	}

}
