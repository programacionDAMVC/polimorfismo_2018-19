package com.iesvirgendelcarmen.teoria.interfaces8;

public interface Empleado {

	
	CategoriaProfesional getcProfesional(); //a implementar por las clases hijas
	
	default double getSueldoNeto() {
		CategoriaProfesional cP = getcProfesional();
		
		switch (cP) {
		case JEFE: 
			return CategoriaProfesional.JEFE.getSueldo() * 0.8;
		case TECNICO:
			return CategoriaProfesional.TECNICO.getSueldo() * 0.85;
		case OBRERO:
			return CategoriaProfesional.OBRERO.getSueldo() * 0.92;
		}
		return 0.0;
	}

	static boolean comprobarDepartamento(String departamento) {
		return departamento.toLowerCase().matches("administraci[óo]n")  ||
				departamento.toLowerCase().matches("f[áa]brica") ||
				departamento.toLowerCase().matches("ingenier[íi]a"); 
	}
	
	default	String toStringEmpleado() {
		return String.format("Soy un empleado de categoría profesional %S y con sueldo neto %.2f"
				, getcProfesional(), getSueldoNeto());
	}
	

}
