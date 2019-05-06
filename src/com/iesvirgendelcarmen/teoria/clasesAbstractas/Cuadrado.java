package com.iesvirgendelcarmen.teoria.clasesAbstractas;

public class Cuadrado extends FiguraCuadratica{
	private double lado;
	
	public Cuadrado(double lado) {
		this.lado = lado;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return lado * lado;
	}

	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return lado * 4.0;
	}

	@Override
	public double getDiagonal() {
		// TODO Auto-generated method stub
		return lado * Math.sqrt(2.0);
	}
	
	@Override
	public String toString() {
		return String.format("Soy un cuadrado de lado %.2f", lado);
	}
}
