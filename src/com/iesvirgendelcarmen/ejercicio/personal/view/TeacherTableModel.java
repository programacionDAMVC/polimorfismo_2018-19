package com.iesvirgendelcarmen.ejercicio.personal.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.iesvirgendelcarmen.ejercicio.personal.model.Person;
import com.iesvirgendelcarmen.ejercicio.personal.model.SubstituteTeacher;
import com.iesvirgendelcarmen.ejercicio.personal.model.PrincipalTeacher;
import com.iesvirgendelcarmen.ejercicio.personal.model.Teacher;

public class TeacherTableModel extends AbstractTableModel{
	private List<Person> listTeachers;
	private String[] columName = {"First Name", "Last Name", "email", "Gender", "Subject", "Career"};

	public TeacherTableModel(List<Person> listTeachers) {
		this.listTeachers = listTeachers;
		if (!listTeachers.isEmpty())
			if (listTeachers.get(0) instanceof SubstituteTeacher){
				//String[] columName = {"First Name", "Last Name", "email", "Gender", "Subject", "Career"};
				//columNameSize = columName.length;
			} else {
				columName[columName.length -1] = "Contract";
			}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columName.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listTeachers.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
		case 0:
			return listTeachers.get(arg0).getFirstName();
		case 1:
			return listTeachers.get(arg0).getLastName();
		case 2:
			return listTeachers.get(arg0).getEmail();
		case 3:
			return listTeachers.get(arg0).getGender().toString();
		case 4:
			return ((Teacher) listTeachers.get(arg0)).getSubject();
		default:
			if (listTeachers.get(arg0) instanceof SubstituteTeacher)
				return ((SubstituteTeacher) listTeachers.get(arg0)).getCareer();
			else 
				return ( (PrincipalTeacher) listTeachers.get(arg0)).getContract();
		}
		
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		 return columName[column];
	}
}
