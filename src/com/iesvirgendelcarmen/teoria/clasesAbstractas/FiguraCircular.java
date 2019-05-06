package com.iesvirgendelcarmen.teoria.clasesAbstractas;

public abstract class FiguraCircular extends FiguraGeometrica {

	public FiguraCircular() {
		super("Figura circular");
		// TODO Auto-generated constructor stub
	}

	public abstract double getArea();

	public abstract double getPerimetro(); 
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Soy una figura circular";
	}

}
