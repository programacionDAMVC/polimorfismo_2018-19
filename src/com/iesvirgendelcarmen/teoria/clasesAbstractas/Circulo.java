package com.iesvirgendelcarmen.teoria.clasesAbstractas;


public class Circulo extends FiguraCircular {
	private double radio;

	public Circulo(double radio) {
		this.radio = radio;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radio, 2);
	}

	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return 2.0 * Math.PI * radio;
	}
	
	@Override
	public String toString() {
		return String.format("Soy un circulo de radio %.2f", radio);
	}
	
	
	
}
