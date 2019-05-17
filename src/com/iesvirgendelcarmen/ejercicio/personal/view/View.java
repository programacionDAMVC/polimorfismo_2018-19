package com.iesvirgendelcarmen.ejercicio.personal.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.iesvirgendelcarmen.ejercicio.personal.model.PersonalDAO;
import com.iesvirgendelcarmen.ejercicio.personal.model.PersonalDAORelational;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class View {

	private JFrame frame;
	private TableModel tableModel;
	private PersonalDAO pDao;
	private JTable jTable;
	private JScrollPane jScrollPane;

	/**
	 * Create the application.
	 */
	public View() {
		pDao = new PersonalDAORelational();
		tableModel = new StudentTableModel(pDao);
		//tableModel = new DeletePersonTableModel(pDao);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelTable = new JPanel();
		jTable = new JTable(tableModel);
		jScrollPane = new JScrollPane(jTable);
		panelTable.add(jScrollPane);
		frame.getContentPane().add(panelTable, BorderLayout.CENTER);
		
		JPanel panelButton = new JPanel();
		frame.getContentPane().add(panelButton, BorderLayout.SOUTH);
		
		JButton buttonShowDeletePerson = new JButton("List Delete Person");
//		buttonShowDeletePerson.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				tableModel = new DeletePersonTableModel(pDao);
//				jTable.setModel(tableModel);
//				System.out.println("pulsado botón");
//				
//			}
//		});
		buttonShowDeletePerson.addActionListener(e -> {
			tableModel = new DeletePersonTableModel(pDao);
			jTable.setModel(tableModel);
		});
		
		panelButton.add(buttonShowDeletePerson);
		
		JPanel panelForm = new JPanel();
		frame.getContentPane().add(panelForm, BorderLayout.WEST);
		
		
		frame.setVisible(true);
	}

}
