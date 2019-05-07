package com.iesvirgendelcarmen.teoria.interfaces8;

public class Jefe extends EmpleadoEmpresa{
	
	private boolean accionista;

	public Jefe(Departamento departamento, boolean accionista) {
		super(departamento, CategoriaProfesional.JEFE);
		this.accionista = accionista;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s, y accionista %B", super.toString(), accionista);
	}
	
	
	
	
	
	
	
	
}
