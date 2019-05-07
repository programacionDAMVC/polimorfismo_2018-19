package com.iesvirgendelcarmen.teoria.interfaces8;

import java.util.ArrayList;
import java.util.List;

public class TestEmpleados {

	public static void main(String[] args) {
		Empleado e1 = new Jefe(Departamento.ADMINISTRACION, true );
		Empleado e2 = new Jefe(Departamento.FABRICA, false );
		Empleado e3 = new Tecnico(Departamento.INGENIERIA, "Ingeniero informática");
		Empleado e4 = new Tecnico(Departamento.ADMINISTRACION, "Economista");
		Empleado e5 = new Obrero(Departamento.FABRICA, false);
		Empleado e6 = new Obrero(Departamento.ADMINISTRACION, true);
		List<Empleado> listaEmpleados = new ArrayList<>();
		listaEmpleados.add(e6); listaEmpleados.add(e5); listaEmpleados.add(e4);
		listaEmpleados.add(e3); listaEmpleados.add(e2); listaEmpleados.add(e1);
		imprimirDatos(listaEmpleados);
		
	
	}
	
	public static void imprimirDatos(List<Empleado> listaEmpleados) {
		listaEmpleados.forEach(System.out::println);
	}

}
