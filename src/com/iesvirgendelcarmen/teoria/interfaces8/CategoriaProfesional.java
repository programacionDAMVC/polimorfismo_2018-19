package com.iesvirgendelcarmen.teoria.interfaces8;

public enum CategoriaProfesional {
	//JEFE, TECNICO, OBRERO;
	JEFE(3000), TECNICO(2000), OBRERO(1200);
	
	private int sueldo;
	 CategoriaProfesional(int sueldo) {
		this.sueldo = sueldo;
	}
	
	public int getSueldo() {
		return sueldo;
	}
}

