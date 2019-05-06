package com.iesvirgendelcarmen.teoria.clasesAbstractas;

import java.util.ArrayList;
import java.util.List;

public class TestClasesAbstractas {

	public static void main(String[] args) {

		FiguraGeometrica f1 = null;
		//	f1 = new FiguraGeometrica("figura geometrica");
		FiguraCircular fc1 = null;
		//	fc1 = new FiguraCircular();
		FiguraCircular fcc = new Circulo(12);
		System.out.printf("%S, de área %.2f y perímetro %.2f%n",
				fcc.toString(), fcc.getArea(), fcc.getPerimetro());
		FiguraCircular fce = new Elipse(2 , 1);
		System.out.printf("%S, de área %.2f y perímetro %.2f%n",
				fce.toString(), fce.getArea(), fce.getPerimetro());
		FiguraCuadratica fC1 = null;
		//	fC1 = new FiguraCuadratica();
		FiguraCuadratica fCc = new Cuadrado(2.3);
		System.out.printf("%S, de área %.2f, perímetro %.2f y diagonal %.2f%n",
				fCc.toString(), fCc.getArea(), fCc.getPerimetro(), fCc.getDiagonal());
		FiguraCuadratica fCr = new Rectangulo(2, 3);
		System.out.printf("%S, de área %.2f, perímetro %.2f y diagonal %.2f%n",
				fCr.toString(), fCr.getArea(), fCr.getPerimetro(), fCr.getDiagonal());
		//Crear una colección de objetos FiguraGeometrica
		List<FiguraGeometrica> lista = new ArrayList<>();
		lista.add(fcc); lista.add(fce); lista.add(fCc); lista.add(fCr);
		System.out.println("\n\n");
		imprimirLista(lista);

	}

	public static void imprimirLista(List<FiguraGeometrica> lista) {
		lista.forEach(System.out::println);
		System.out.println("\n\n");
		for (FiguraGeometrica fG : lista) {
			if (fG instanceof FiguraCuadratica) {
				System.out.printf("%S, de área %.2f, perímetro %.2f y diagonal %.2f%n",
						fG.toString(), fG.getArea(), fG.getPerimetro(),	
						((FiguraCuadratica) fG).getDiagonal());
			}
			else {
				System.out.printf("%S, de área %.2f y perímetro %.2f%n",
						fG.toString(), fG.getArea(), fG.getPerimetro());
			}

		}
	}

}
