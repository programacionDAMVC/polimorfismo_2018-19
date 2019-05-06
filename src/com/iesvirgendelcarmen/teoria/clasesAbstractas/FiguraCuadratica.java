package com.iesvirgendelcarmen.teoria.clasesAbstractas;

public abstract class FiguraCuadratica extends FiguraGeometrica{

	public FiguraCuadratica() {
		super("Figura de cuatro lados");
	}

	
	public abstract double getArea();

	
	public abstract double getPerimetro();
	
	public abstract double getDiagonal();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Soy una figura de cuatro lados";
	}
	

}
