package edu.gsu.cis3270.project.gui;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.ListModel;

import edu.gsu.cis3270.project.database.FlightDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class MainScreen extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JList list;

	/**
	 * Create the panel.
	 */
	public MainScreen() {
		
		Vector<String> alist = new Vector<String>();
		Vector<String> blist = new Vector<String>();
		/*JList list = new JList();
		add(list);*/
		
		try {
			ResultSet rs = FlightDatabase.searchAll();
			
			while(rs.next()) {
				alist.add(rs.getString("FID")+"        "+rs.getString("CITY_FROM")
				+"        "+rs.getString("CITY_TO")+"        "+rs.getString("FLIGHT_DATE"));			
			}
			list = new JList(alist);
			getContentPane().add(list);
			
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			
			JLabel lblFrom = new JLabel("From:");
			
			textField = new JTextField();
			textField.setColumns(3);
			
			JLabel lblTo = new JLabel("To:");
			
			textField_1 = new JTextField();
			textField_1.setColumns(3);
			
			JLabel lblDate = new JLabel("Date:");
			
			textField_2 = new JTextField();
			textField_2.setColumns(12);
			
			JButton btnSearch = new JButton("Search");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						String startDate=textField_2.getText().toString();
						SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
						java.sql.Date sqlDate = new java.sql.Date(sdf1.parse(startDate).getTime());
						ResultSet r = FlightDatabase.searchFlight(textField.getText().toString().toUpperCase(),
																	textField_1.getText().toString().toUpperCase(),
																	sqlDate);
						
						getContentPane().remove(list);
						alist.removeAllElements();
						while(rs.next()) {
							alist.add(r.getString("FID")+"        "+r.getString("CITY_FROM")
							+"        "+r.getString("CITY_TO")+"        "+r.getString("FLIGHT_DATE"));			
						}
						list = new JList(alist);
						getContentPane().add(list);
						getContentPane().invalidate();
						getContentPane().validate();
						
					} catch (ParseException e) {
						textField_2.setText("e:Wrong format");
					} catch (SQLException e) {
						JOptionPane.showInternalMessageDialog(panel, "An error occurred with the database."
												+ "Please restart the application",
												"Database Error",
												ERROR);
					}
				}
			});
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblFrom)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblTo)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(28)
						.addComponent(lblDate)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
						.addComponent(btnSearch)
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblFrom)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTo)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSearch)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDate)))
			);
			panel.setLayout(gl_panel);
			
			JPanel panel_1 = new JPanel();
			getContentPane().add(panel_1, BorderLayout.SOUTH);
			
			JButton btnLogout = new JButton("Logout");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					MainApplication.main(new String[0]);
				}
			});
			
			JButton btnSettings = new JButton("Settings");
			btnSettings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Change to panel containing user settings
				}
			});
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(btnSettings)
						.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
						.addComponent(btnLogout)
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLogout)
							.addComponent(btnSettings))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel_1.setLayout(gl_panel_1);
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
	}
}
