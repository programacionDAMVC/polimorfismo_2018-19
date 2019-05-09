package com.iesvirgendelcarmen.ejercicio.personal.model.repository;

import java.sql.Connection;

public interface ConnectionDB {
	Connection getConnection();
	void closeConnection();
	
}
