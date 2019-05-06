package com.iesvirgendelcarmen.teoria.interfaces8;

public class TestInterfacesFuncionales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfazFuncional iSuma = new ClaseSuma();
		InterfazFuncional iMult = new ClaseMultiplicacion();
		
		System.out.println("3 + 2 vale " + iSuma.operacionMatematica(3, 2));
		System.out.println("3 * 2 vale " + iMult.operacionMatematica(3, 2));
		
		InterfazFuncional iDivid = new InterfazFuncional() {
			
			@Override
			public double operacionMatematica(double x, double y) {
				// TODO Auto-generated method stub
				return x / y;
			}
		};
		System.out.println("3 / 2 vale " + iDivid.operacionMatematica(3, 2));
		
		InterfazFuncional iElevar = new InterfazFuncional() {
			
			@Override
			public double operacionMatematica(double x, double y) {
				// TODO Auto-generated method stub
				return Math.pow(x, y);
			}
		};
		System.out.println("3^2 vale " + iElevar.operacionMatematica(3, 2));
		
		InterfazFuncional iRaiz = (x , y) -> Math.pow(x, 1/y);
		System.out.println("3^ 1/2 vale " + iRaiz.operacionMatematica(3, 2));

	}

}
