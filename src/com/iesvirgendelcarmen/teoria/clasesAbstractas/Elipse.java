package com.iesvirgendelcarmen.teoria.clasesAbstractas;

public class Elipse extends FiguraCircular {

	private double semiejeMayor;
	private double semiejeMenor;
	
	public Elipse(double semiejeMayor, double semiejeMenor) {
		this.semiejeMayor = semiejeMayor;
		this.semiejeMenor = semiejeMenor;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * semiejeMayor * semiejeMenor;
	}
	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return 2.0 * Math.PI * Math.sqrt(
				(Math.pow(semiejeMayor,2) + Math.pow(semiejeMenor,2)) / 2.0);
	}
	@Override
	public String toString() {
		return String.format("Soy una elipse de semieje mayor %.2f y semieje menor %.2f", 
				semiejeMayor, semiejeMenor);
	}
}
