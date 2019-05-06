package com.iesvirgendelcarmen.teoria.interfaces.previo8.test;

import com.iesvirgendelcarmen.teoria.interfaces.previo8.ClaseA;
import com.iesvirgendelcarmen.teoria.interfaces.previo8.ClaseB;
import com.iesvirgendelcarmen.teoria.interfaces.previo8.ClaseC;
import com.iesvirgendelcarmen.teoria.interfaces.previo8.InterfazA;
import com.iesvirgendelcarmen.teoria.interfaces.previo8.InterfazB;

public class TestInterfaces {

	public static void main(String[] args) {
		ClaseA claseA = new ClaseA();
		System.out.printf("Valor de la constante %d, y su valor doble es %d%n",
				InterfazA.MI_CONSTANTE, claseA.doblar());
		InterfazA interfazA = new ClaseA();
		System.out.printf("Valor de la constante %d, y su valor triple es %d%n",
				InterfazA.MI_CONSTANTE, interfazA.triplicar());
		claseA.cuadruplicar();
		((ClaseA) interfazA).cuadruplicar();
		ClaseB claseB1 = new ClaseB();
		claseB1.cuadruplicar(); //llama al método cudruplicar() de la claseB
		ClaseA claseB2 = new ClaseB();
		claseB2.cuadruplicar(); //llama al método cudruplicar() de la claseA
		((ClaseB) claseB2).cuadruplicar(); //llama al método cudruplicar() de la claseB
		InterfazA claseB3 = new ClaseB();
		((ClaseB) claseB3).cuadruplicar();//llama al método cudruplicar() de la claseB
		((ClaseA) claseB3).cuadruplicar();//llama al método cudruplicar() de la claseA
		
		InterfazB claseC1 = new ClaseC();
		claseC1.cuadruplicar();//llama al método cuadruplicar() definido en la interfazB
		InterfazA claseC2 = new ClaseC();
		((ClaseA) claseC2).cuadruplicar();
		((InterfazB) claseC2).cuadruplicar();
	}

}
