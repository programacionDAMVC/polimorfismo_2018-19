package com.iesvirgendelcarmen.teoria.interfaces.previo8;

public class ClaseA implements InterfazA {

	@Override
	public int doblar() {
		// TODO Auto-generated method stub
		return InterfazA.MI_CONSTANTE * 2;
	}

	@Override
	public int triplicar() {
		// TODO Auto-generated method stub
		return InterfazA.MI_CONSTANTE * 3;
	}
	
	public  int cuadruplicar() {
		return InterfazA.MI_CONSTANTE * 4;
	}

}
