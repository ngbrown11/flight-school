package edu.gsu.cis3270.project.gui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import edu.gsu.cis3270.project.user.Admin;
import edu.gsu.cis3270.project.user.Customer;
import edu.gsu.cis3270.project.user.User;

import com.jgoodies.forms.layout.FormSpecs;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterScreen extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public RegisterScreen() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(191dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(4dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblType = new JLabel("TYPE");
		add(lblType, "2, 2, default, bottom");
		
		JLabel lblNewUserRegistration = new JLabel("New User Registration");
		lblNewUserRegistration.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblNewUserRegistration, "6, 2, center, default");
		
		//Create radio button group
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton rdbtnCust = new JRadioButton("C");
		add(rdbtnCust, "2, 4, default, top");
		bg.add(rdbtnCust);
		
		JLabel lblFirstName = new JLabel("First Name:");
		add(lblFirstName, "4, 4, left, default");
		
		textField = new JTextField();
		add(textField, "6, 4, fill, default");
		textField.setColumns(20);
		
		JRadioButton rdbtnAdmin = new JRadioButton("A");
		add(rdbtnAdmin, "2, 6, default, top");
		bg.add(rdbtnAdmin);
		
		JLabel lblLastName = new JLabel("Last Name:");
		add(lblLastName, "4, 6, left, default");
		
		textField_1 = new JTextField();
		add(textField_1, "6, 6, fill, default");
		textField_1.setColumns(20);
		
		JLabel lblAddress = new JLabel("Address:");
		add(lblAddress, "4, 8, left, default");
		
		textField_2 = new JTextField();
		add(textField_2, "6, 8, fill, default");
		textField_2.setColumns(40);
		
		JLabel lblState = new JLabel("State:");
		add(lblState, "4, 10, left, default");
		
		textField_3 = new JTextField();
		add(textField_3, "6, 10, fill, default");
		textField_3.setColumns(2);
		
		JLabel lblZip = new JLabel("Zip Code:");
		add(lblZip, "4, 12, left, default");
		
		textField_4 = new JTextField();
		add(textField_4, "6, 12, fill, default");
		textField_4.setColumns(5);
		
		JLabel lblSsn = new JLabel("SSN:");
		add(lblSsn, "4, 14, left, default");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(9);
		add(passwordField, "6, 14, fill, default");
		
		JLabel lblEmail = new JLabel("Email:");
		add(lblEmail, "4, 18, left, default");
		
		textField_5 = new JTextField();
		add(textField_5, "6, 18, fill, default");
		textField_5.setColumns(40);
		
		JLabel lblUsername = new JLabel("Username:");
		add(lblUsername, "4, 20, left, default");
		
		textField_6 = new JTextField();
		add(textField_6, "6, 20, fill, default");
		textField_6.setColumns(20);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "4, 22, left, default");
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(20);
		add(passwordField_1, "6, 22, fill, default");
		
		JButton btnRegister = new JButton("Reg");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ssn = "";
				String pass = "";
				for(char a : passwordField.getPassword()) {
					ssn = ssn + String.valueOf(a);
				}
				for(char a : passwordField_1.getPassword()) {
					pass = pass + String.valueOf(a);
				}
				if(rdbtnCust.isSelected()) {
					User user = new Customer(textField.getText(), textField_1.getText(), 
							textField_2.getText(), Integer.parseInt(textField_4.getText()), 
							textField_3.getText(), ssn, 
							textField_5.getText(), textField_6.getText(), pass, 
							1, "Set");
					dispose();
				}
				else if(rdbtnAdmin.isSelected()) {
					User user = new Admin(textField.getText(), textField_1.getText(), 
							textField_2.getText(), Integer.parseInt(textField_4.getText()), 
							textField_3.getText(), ssn, 
							textField_5.getText(), textField_6.getText(), pass, 
							1, "Set");
					dispose();
				}
			}
		});
		add(btnRegister, "8, 22, left, default");

	}

}
