package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iesvirgendelcarmen.ejercicio.personal.model.repository.ConnectionDBSqlite;

public class PersonalDAORelational implements PersonalDAO {
	private List<Student> studentList = new ArrayList<>();
	private List<PrincipalTeacher> principalTeacherList = new ArrayList<>();
	private List<SubstituteTeacher> substituteTeacherList = new ArrayList<>();

	public PersonalDAORelational() {
		fillStudentList();
	}
	private void fillStudentList() {
		// conectarme a la BD
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
		connectionDBSqlite.closeConnection();



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
		int rows = 0;
		ConnectionDBSqlite connectionDBSqlite = new ConnectionDBSqlite();
		Connection connection = connectionDBSqlite.getConnection();
		String sql = " DELETE FROM person WHERE emailPerson = ? ;";
		try (PreparedStatement psStatement = connection.prepareStatement(sql);
				)
		{
			psStatement.setString(1, person.getEmail());
			rows = psStatement.executeUpdate();
			if (rows != 0)
				if (person instanceof Student)
					studentList.remove(person);
				else if (person instanceof PrincipalTeacher)
					//borramos de la lista profesores titulares
					System.out.println();
				else
					//borramos de la lista profesores interinos
					System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionDBSqlite.closeConnection();
		return rows != 0;
	}

	@Override
	public Person getPersonByEmail(Person person) {
		String sql = null;
		if (person instanceof Student)
			sql = "SELECT * FROM student_view WHERE emailPerson = ?;";
		else if (person instanceof PrincipalTeacher)
			sql = "SELECT * FROM principalTeacher_view WHERE emailPerson = ?;";
		else
			//localizar el índice del objeto person
			//es distinto a -1, existe:
			//localizamos get(index)
			System.out.println();
		return null;
	}

	
	

	@Override
	public List<Person> getDeletePerson() {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		PersonalDAO pDao = new PersonalDAORelational();
		Person p = new Student("", "", "sthemanndt@indiegogo.com",null,"");
		System.out.println(pDao.deletePerson(p));
		pDao.getStudents().forEach(System.out::println);
	}
	

}
