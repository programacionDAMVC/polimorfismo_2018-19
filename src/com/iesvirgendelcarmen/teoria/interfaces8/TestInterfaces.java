package com.iesvirgendelcarmen.teoria.interfaces8;

public class TestInterfaces {

	public static void main(String[] args) {
		Interfaz1 i1 = new Clase1(); //lo correcto: POLIMORFISMO
		System.out.println(i1.valorDoble(2));  //método sobrescrito
		System.out.println(i1.valorTriple(2));
		
		Clase1 c1 = new Clase1();
		System.out.println(c1.valorDoble(2)); //método sobrescrito
		System.out.println(c1.valorTriple(2));
		
		System.out.println(Interfaz1.valorCuadruple(2));
		
		i1.mostrarValorMensaje("hola");
	}

}
