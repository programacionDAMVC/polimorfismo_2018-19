package com.iesvirgendelcarmen.ejercicio.personal.model.repository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.sqlite.SQLiteConfig;

public class ConnectionDBSqlite implements ConnectionDB{
	private Connection connection;
	@Override
	public Connection getConnection() {
		
		SQLiteConfig  config = new  SQLiteConfig ();
		config.enforceForeignKeys(true);
		Properties properties = new Properties();
		try {
			properties.load(new FileReader("config/config.properties"));
			String DRIVER = properties.getProperty("DRIVER");
			String URL    = properties.getProperty("URL");
			connection = DriverManager.getConnection(DRIVER + URL, config.toProperties());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
		
	}

	@Override
	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		ConnectionDBSqlite ConnectionDBSqlite = new ConnectionDBSqlite();
		System.out.println(ConnectionDBSqlite.getConnection());
	}

}
