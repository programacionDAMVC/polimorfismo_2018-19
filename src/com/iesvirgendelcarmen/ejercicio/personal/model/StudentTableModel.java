package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class StudentTableModel extends AbstractTableModel{
	private PersonalDAO pDao = new PersonalDAORelational();
	private List<Student> listStudent = pDao.getStudents();
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
			return listStudent.get(arg0).getCourse();
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
