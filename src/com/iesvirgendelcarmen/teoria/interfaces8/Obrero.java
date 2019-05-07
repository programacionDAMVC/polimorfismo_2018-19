package com.iesvirgendelcarmen.teoria.interfaces8;

public class Obrero extends EmpleadoEmpresa{
	
	private boolean oficial;

	public Obrero(Departamento departamento, boolean oficial) {
		super(departamento, CategoriaProfesional.OBRERO);
		this.oficial = oficial;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s, y oficial %B", super.toString(), oficial);
	}
	
	
	
	

	
}
