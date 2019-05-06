package com.iesvirgendelcarmen.teoria.clasesAbstractas;

public abstract class FiguraGeometrica {
	private String nombre;

	public FiguraGeometrica(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return String.format("Soy una figuraGeometrica (%s)", nombre);
	}
	
	public abstract double getArea();
	
	public abstract double getPerimetro();
	
}
