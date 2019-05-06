package com.iesvirgendelcarmen.teoria.clasesAbstractas;

public class Rectangulo extends FiguraCuadratica {
	private double ladoMayor;
	private double ladoMenor;
	
	public Rectangulo(double ladoMayor, double ladoMenor) {
		this.ladoMayor = ladoMayor;
		this.ladoMenor = ladoMenor;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return ladoMayor * ladoMenor;
	}

	@Override
	public double getPerimetro() {
		// TODO Auto-generated method stub
		return ladoMayor * 2.0 + ladoMenor *2.0;
	}

	@Override
	public double getDiagonal() {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(ladoMenor, 2) + Math.pow(ladoMayor, 2));
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Soy un rectángulo de lado mayor %.2f y lado menor %.2f",
				ladoMayor, ladoMenor);
	}

}
