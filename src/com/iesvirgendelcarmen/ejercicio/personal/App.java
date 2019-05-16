package com.iesvirgendelcarmen.ejercicio.personal;

import java.awt.EventQueue;

import com.iesvirgendelcarmen.ejercicio.personal.view.View;

public class App {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
