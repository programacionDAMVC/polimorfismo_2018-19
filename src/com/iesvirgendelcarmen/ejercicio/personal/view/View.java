package com.iesvirgendelcarmen.ejercicio.personal.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import com.iesvirgendelcarmen.ejercicio.personal.controller.Controller;
import com.iesvirgendelcarmen.ejercicio.personal.model.PersonalDAO;
import com.iesvirgendelcarmen.ejercicio.personal.model.PersonalDAORelational;

import java.awt.BorderLayout;
import javax.swing.JButton;

public class View {

	private JFrame frame;
	private TableModel tableModel;
	//private PersonalDAO pDao;
	private JTable jTable;
	private JScrollPane jScrollPane;
	private Controller controller;

	/**
	 * Create the application.
	 */
	public View() {
		controller = new Controller(this);
		//	pDao = new PersonalDAORelational();
		tableModel = new StudentTableModel(controller.getListPeople("student"));
		//tableModel = new DeletePersonTableModel(pDao);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
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
		JButton buttonDelete = new JButton("Delete");

		buttonShowDeletePerson.addActionListener(e -> {
			tableModel = new DeletePersonTableModel(controller.getListPeople("deletePerson"));
			jTable.setModel(tableModel);
			buttonDelete.setEnabled(false);
		});
		JButton buttonListStudent = new JButton("List Students");
		buttonListStudent.addActionListener(e -> {
			tableModel = new StudentTableModel(controller.getListPeople("student"));
			jTable.setModel(tableModel);
			buttonDelete.setEnabled(true);
		});
		JButton buttonPrincipalTeacher = new JButton("List Principal Teacher");
		buttonPrincipalTeacher.addActionListener(e -> {
			tableModel = new TeacherTableModel(controller.getListPeople("principalTeacher"));
			jTable.setModel(tableModel);
			buttonDelete.setEnabled(true);
		});
		JButton buttonSubstituteTeacher = new JButton("List Substitute Teacher");
		buttonSubstituteTeacher.addActionListener(e -> {
			tableModel = new TeacherTableModel(controller.getListPeople("substituteTeacher"));
			jTable.setModel(tableModel);
			buttonDelete.setEnabled(true);
		});

		buttonDelete.addActionListener(ev -> {
			List<String> listEmail = new ArrayList<>();
			//llamar la controlador, pasarle email a borrar
			int[] row = jTable.getSelectedRows();
			if (row.length != 0 );
				for (int i = 0; i < row.length; i++) 
					listEmail.add((String) tableModel.getValueAt(row[i],2));
				//System.out.println(listEmail);
				controller.deletePeople(listEmail);
				((StudentTableModel) tableModel).removeRow();
				
			
		});

		panelButton.add(buttonDelete);
		panelButton.add(buttonShowDeletePerson);
		panelButton.add(buttonListStudent);
		panelButton.add(buttonPrincipalTeacher);
		panelButton.add(buttonSubstituteTeacher);


		JPanel panelForm = new JPanel();
		frame.getContentPane().add(panelForm, BorderLayout.WEST);


		frame.setVisible(true);
	}

}
