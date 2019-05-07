package com.iesvirgendelcarmen.teoria.interfaces8;

public class Tecnico extends EmpleadoEmpresa {
	
	private String titulacion;

	public Tecnico(Departamento departamento, String titulacion) {
		super(departamento, CategoriaProfesional.TECNICO);
		this.titulacion = titulacion;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s, y de titulación %s", super.toString(), titulacion);
	}
	
	
}
