package com.iesvirgendelcarmen.teoria.interfaces8;

public interface Interfaz1 {
	
	default double valorDoble(double valor) {
		return valor * 2.0;
	}
	default double valorTriple(double valor) {
		return valor * 3.0;
	}
	
	static double valorCuadruple(double valor) { //método NO se sobrescribe
		return valor * 4.0;
	}
	
	private String mostrarMensaje(String mensaje) { //a partir JDK 9
		return String.format("Mensaje recibido: %S", mensaje);
	}
	
	default void mostrarValorMensaje(String mensaje) {
		System.out.println(mostrarMensaje(mensaje));
	}
}
