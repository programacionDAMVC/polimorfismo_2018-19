package com.iesvirgendelcarmen.teoria.interfaces8;

class Prueba {
	public static void main(String[] args) {
		for (CategoriaProfesional cP : CategoriaProfesional.values()) {
			System.out.printf("%s, sueldo: %d%n", cP, cP.getSueldo());
		}
	}
}
