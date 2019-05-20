package com.iesvirgendelcarmen.ejercicio.personal.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.iesvirgendelcarmen.ejercicio.personal.model.DeletePerson;
import com.iesvirgendelcarmen.ejercicio.personal.model.Person;

public class DeletePersonTableModel extends AbstractTableModel{
	//private PersonalDAO pDao;
	private List<Person> listDeletePerson;
	
	public DeletePersonTableModel(List<Person> listDeletePerson) {
	//	this.pDao = pDao;
		this.listDeletePerson = listDeletePerson;
	}
	//= pDao.getDeletePerson();
	private String[] columName = {"First Name", "Last Name", "email", "Gender", "Date"};
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columName.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listDeletePerson.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
		case 0:
			return listDeletePerson.get(arg0).getFirstName();
		case 1:
			return listDeletePerson.get(arg0).getLastName();
		case 2:
			return listDeletePerson.get(arg0).getEmail();
		case 3:
			return listDeletePerson.get(arg0).getGender().toString();
		case 4:
			return ((DeletePerson) listDeletePerson.get(arg0)).getDeleteDate();
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
