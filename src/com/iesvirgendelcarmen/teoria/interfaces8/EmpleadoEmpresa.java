package com.iesvirgendelcarmen.teoria.interfaces8;

public class EmpleadoEmpresa implements Empleado{
	
	private Departamento departamento;
	private CategoriaProfesional cProfesional;
	
	public EmpleadoEmpresa(Departamento departamento, CategoriaProfesional cProfesional) {
		this.departamento = departamento;
		this.cProfesional = cProfesional;
	}

	@Override
	public CategoriaProfesional getcProfesional() {
		// TODO Auto-generated method stub
		return cProfesional;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s, y del departamento %S"
				, toStringEmpleado(), departamento );
	}
}
