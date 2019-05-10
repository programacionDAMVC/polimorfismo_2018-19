package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iesvirgendelcarmen.ejercicio.personal.model.repository.ConnectionDBSqlite;

public class PersonalDAORelational implements PersonalDAO {
	private List<Student> studentList = new ArrayList<>();
	public PersonalDAORelational() {
		fillStudentList();
	}
	private void fillStudentList() {
		// conectarmen a la BD
		ConnectionDBSqlite connectionDBSqlite = new ConnectionDBSqlite();
		Connection connection = connectionDBSqlite.getConnection();
		String sql = "SELECT * FROM student_view;";
		try (Statement statement = connection.createStatement();) {
			// ejecutar sentencia query
			ResultSet rsSet = statement.executeQuery(sql);
			// rellenar la lista studentList
			while (rsSet.next()) {
				String firstName = rsSet.getString("firstName");
				String lastName  = rsSet.getString("lastName");
				String email     = rsSet.getString("emailPerson");
				String sGender   = rsSet.getString("gender");
				Gender gender = Gender.MALE;
				if (sGender.equals("Female")){
					gender = Gender.FEMALE;
				}
				String course  =rsSet.getString("course");
				studentList.add(new Student(firstName, lastName, email, gender, course));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentList;
	}

	@Override
	public List<PrincipalTeacher> getPrincipalTeachers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubstituteTeacher> getSubstituteTeachers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePerson(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Student getStudentsByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrincipalTeacher getPrincipalTeachersByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubstituteTeacher getSubstituteTeachersByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getDeletePerson() {
		// TODO Auto-generated method stub
		return null;
	}


}
