package com.iesvirgendelcarmen.ejercicio.personal.model.repository;

import java.sql.Connection;

import org.sqlite.SQLiteConfig;

public class ConnectionDBSqlite implements ConnectionDB{

	@Override
	public Connection getConnection() {
		SQLiteConfig  config = new  SQLiteConfig ();
		config.enforceForeignKeys(true);
		return null;
	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}

}
