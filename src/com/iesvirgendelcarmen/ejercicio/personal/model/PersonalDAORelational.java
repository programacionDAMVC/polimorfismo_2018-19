package com.iesvirgendelcarmen.ejercicio.personal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.iesvirgendelcarmen.ejercicio.personal.model.repository.ConnectionDBSqlite;

public class PersonalDAORelational implements PersonalDAO {
	private List<Person> studentList = new ArrayList<>();
	private List<PrincipalTeacher> principalTeacherList = new ArrayList<>();
	private List<SubstituteTeacher> substituteTeacherList = new ArrayList<>();

	public PersonalDAORelational() {
		fillStudentList();
		fillSubstituteTeacher();
		fillPrincipalTeacher();
	}
	private void fillPrincipalTeacher() {
		ConnectionDBSqlite connectionDBSqlite = new ConnectionDBSqlite();
		Connection connection = connectionDBSqlite.getConnection();
		String sql = "SELECT * FROM principalTeacher_view;";
		try (Statement statement = connection.createStatement();){
			ResultSet rsSet = statement.executeQuery(sql);
			while(rsSet.next()) {
				String firstName = rsSet.getString("firstName");
				String lastName  = rsSet.getString("lastName");
				String email     = rsSet.getString("emailPerson");
				String sGender   = rsSet.getString("gender");
				Gender gender = Gender.MALE;
				if (sGender.equals("Female")){
					gender = Gender.FEMALE;
				}
				String subject  = rsSet.getString("subject");
				String sContract    = rsSet.getString("contract");
				LocalDate lContract = LocalDate.parse(sContract, FORMATTER_DATE);
				principalTeacherList.add(
						new PrincipalTeacher(
								firstName, lastName, email, gender, subject, lContract));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void fillSubstituteTeacher() {
		ConnectionDBSqlite connectionDBSqlite = new ConnectionDBSqlite();
		Connection connection = connectionDBSqlite.getConnection();
		String sql = "SELECT * FROM substituteTeacher_view;";
		//firstName, lastName , emailPerson , gender , subject, career
		try {
			Statement statement = connection.createStatement();
			ResultSet rsSet = statement.executeQuery(sql);
			while (rsSet.next()) {
				String firstName = rsSet.getString("firstName");
				String lastName  = rsSet.getString("lastName");
				String email     = rsSet.getString("emailPerson");
				String sGender   = rsSet.getString("gender");
				Gender gender = Gender.MALE;
				if (sGender.equals("Female")){
					gender = Gender.FEMALE;
				}
				String subject = rsSet.getString("subject");
				int career     = rsSet.getInt("career");
				substituteTeacherList.add(
						new SubstituteTeacher(firstName, lastName, email, gender, subject, career));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
//	@Override
//	public List<Student> getStudents() {
//		// TODO Auto-generated method stub
//		return studentList;
//	}

	@Override
	public List<PrincipalTeacher> getPrincipalTeachers() {
		// TODO Auto-generated method stub
		return principalTeacherList;
	}

	@Override
	public List<SubstituteTeacher> getSubstituteTeachers() {
		// TODO Auto-generated method stub
		return substituteTeacherList;
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
					principalTeacherList.remove(person);
				else
					substituteTeacherList.remove(person);
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
		ConnectionDBSqlite connectionDBSqlite = new ConnectionDBSqlite();
		Connection connection = connectionDBSqlite.getConnection();
		if (person instanceof Student) {
			sql = "SELECT * FROM student_view WHERE emailPerson = ?;";
			try (PreparedStatement psStatement = connection.prepareStatement(sql);){
				psStatement.setString(1, person.getEmail());
				ResultSet rsSet = psStatement.executeQuery();
				//firstName, lastName , emailPerson , gender , course
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
					return new Student(firstName, lastName, email, gender, course);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (person instanceof PrincipalTeacher) {
			//sql = "SELECT * FROM principalTeacher_view WHERE emailPerson = ?;";
			int index = principalTeacherList.indexOf(person);
			if (index != -1)
				return principalTeacherList.get(index);
		}
		else {
			//localizar el índice del objeto person con el método indexOf, devuelve index
			int index = substituteTeacherList.indexOf(person);
			if (index != -1)
				return substituteTeacherList.get(index);
			//es distinto a -1, existe:
			//localizamos get(index)
		}
		connectionDBSqlite.closeConnection();
		return null;
	}

	
	

//	@Override
	private List<Person> getDeletePerson() {
		List<Person> listDeletePerson = new ArrayList<>();
		ConnectionDBSqlite connectionDBSqlite = new ConnectionDBSqlite();
		Connection connection = connectionDBSqlite.getConnection();
		String sql = "SELECT *  FROM record ;";
		try (Statement statement = connection.createStatement();){
			ResultSet rsSet = statement.executeQuery(sql);
			while (rsSet.next()) {
				String firstName = rsSet.getString("firstName");
				String lastName  = rsSet.getString("lastName");
				String email     = rsSet.getString("emailPerson");
				String sGender   = rsSet.getString("gender");
				Gender gender = Gender.MALE;
				if (sGender.equals("Female")){
					gender = Gender.FEMALE;
				}
				String sDate = rsSet.getString("date");
				LocalDateTime lDate = LocalDateTime.parse(sDate, FORMATTER_DATETIME);
				listDeletePerson.add(
						new DeletePerson(firstName, lastName, email, gender, lDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connectionDBSqlite.closeConnection();
		return listDeletePerson;
	}
	@Override
	public List<Person> getListPeople(String type) {
		switch (type) {
		case "deletePerson":
			return getDeletePerson();
			

		default:
			return studentList;
		}
	}

	public static void main(String[] args) {
		PersonalDAO pDao = new PersonalDAORelational();
//		Person p = new Student("", "", "sthemanndt@indiegogo.com",null,"");
//		System.out.println(pDao.deletePerson(p));
//		pDao.getStudents().forEach(System.out::println);
//		Person p1 = new Student("", "", "THESELWOODDS@VIRGINIA.EDU",null,"");
//		System.out.println("Buscando persona:");
//		System.out.println(pDao.getPersonByEmail(p1));
//		pDao.getSubstituteTeachers().forEach(System.out::println);
//		Person p = new SubstituteTeacher("", "", "MBAUMAIER8@SCIENCEDAILY.COM".toLowerCase(), null, "", 0);
//		System.out.println(pDao.deletePerson(p));
//		pDao.getSubstituteTeachers().forEach(System.out::println);
//		Person p1 = new SubstituteTeacher("", "", "JMEGAINEY7@GOOGLE.IT".toLowerCase(), null, "", 0);
//		System.out.println();
//		System.out.println(pDao.getPersonByEmail(p1));
		pDao.getPrincipalTeachers().forEach(System.out::println);
		
	}
	

}
