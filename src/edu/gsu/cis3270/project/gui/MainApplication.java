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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class MainApplication extends JFrame {

	static MainApplication frame;
	private JPanel contentPane;
	private static JPanel screen;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainApplication();
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					frame.setVisible(true);
					
					switchScreens(screen);
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
		
		LoginScreen login = new LoginScreen();
		RegisterScreen register = new RegisterScreen();
		
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
		switchScreens(splash);
		contentPane.add(screen, BorderLayout.CENTER);
		splash.setFont(new Font("Californian FB", Font.BOLD, 52));
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().remove(splash);
				switchScreens(login);
				getContentPane().add(screen);
				getContentPane().invalidate();
				getContentPane().validate();
				pack();
			}
		});
		splash.setLayout(new BorderLayout(0, 0));
		btnStart.setVerticalAlignment(SwingConstants.BOTTOM);
		splash.add(btnStart, BorderLayout.SOUTH);;
	}
	
	public static void switchScreens(JPanel p) {
		screen = p;
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
