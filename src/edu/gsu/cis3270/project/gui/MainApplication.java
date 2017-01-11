package edu.gsu.cis3270.project.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class MainApplication extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication frame = new MainApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApplication() {
		setTitle("Flight School Reservation System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		// Create splash screen message
		SplashMessage splash = new SplashMessage("FSRS v 1.0");
		splash.setBackground(SystemColor.control);
		splash.setForeground(UIManager.getColor("textHighlight"));
		contentPane.add(splash, BorderLayout.CENTER);
		splash.setFont(new Font("Californian FB", Font.BOLD, 52));;
		
		try {
			Thread.sleep(4000);
		} catch(Exception ex) {
			// Create error message
			JOptionPane.showMessageDialog(this,
				    "Something went wrong while loading\nRestart the application",
				    "Load error",
				    JOptionPane.ERROR_MESSAGE);
			
		} finally { // Go to login screen after splash screen
			this.getContentPane().remove(splash);
			this.add(new LoginScreen());
			this.getContentPane().invalidate();
			this.getContentPane().validate();
		}
	}

}

class SplashMessage extends JPanel {
	String m;
	public SplashMessage(String s) {
		this.m = s;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Font metrics
		FontMetrics fm = g.getFontMetrics();
		// Center location
		int stringW = fm.stringWidth(m);
		int stringH = fm.getAscent();
		// Position of left side
		int x = getWidth() / 2 - stringW / 2;
		int y = getHeight() / 2 - stringH / 8;
		// Draw string
		g.drawString(m, x, y);
	}
}
