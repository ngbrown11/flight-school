package edu.gsu.cis3270.project.gui;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import edu.gsu.cis3270.project.database.UserDatabase;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginScreen extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	public LoginScreen() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(47dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(16dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(38dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(90dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(34dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(69dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(5dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(8dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(27dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(5dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(9dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(30dlu;default)"),}));
		
		// Register a new user
		JButton btnNewUser = new JButton("+ User");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RegisterScreen frame = new RegisterScreen();
				frame.setVisible(true);
				frame.pack();
			}
		});
		add(btnNewUser, "12, 4, left, default");
		
		JLabel lblFsrs = new JLabel("FSRS");
		lblFsrs.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblFsrs, "4, 8, 7, 1, center, default");
		
		JLabel lblUsername = new JLabel("Username");
		add(lblUsername, "6, 10, left, default");
		
		textField = new JTextField();
		add(textField, "8, 10, left, default");
		textField.setColumns(16);
		
		JLabel lblPassword = new JLabel("Password");
		add(lblPassword, "6, 12, left, default");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(16);
		add(passwordField, "8, 12, left, default");
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String pass = "";
					for(char a : passwordField.getPassword()) {
						pass = pass + String.valueOf(a);
					}
					boolean success = UserDatabase.searchUser(textField.getText().toString(), pass);
					if(success) {
						MainScreen frame = new MainScreen();
						frame.setVisible(true);
						frame.pack();
						MainApplication.frame.dispose();
					}
					else {
						textField.setText("username/password incorrect");
						passwordField.setText("");
					}
					
				} catch (SQLException e) {
					e.getMessage();
				}
			}
		});
		add(btnLogin, "8, 14, right, default");

	}

}
