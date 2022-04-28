package com.saumya.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class SplashScreen extends JWindow {

	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
				SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.runProgressBar();
		
	}
	JProgressBar progressBar = new JProgressBar();
	
	Timer timer;
	private int count = 0;
	private void runProgressBar() {
		timer = new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				progressBar.setValue(count);
				count++;
				if (count > 100) {
					timer.stop();
					SplashScreen.this.setVisible(false); 
					SplashScreen.this.dispose();
					MainScreen window = new MainScreen();
					window.setVisible(true);
				}
				
			}
		});
		timer.start();
	}
	
	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setBounds(100, 100, 544, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chit Chat");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 50));
		lblNewLabel_1.setBounds(157, 126, 249, 81);
		contentPane.add(lblNewLabel_1);
		
		
		progressBar.setStringPainted(true);
		progressBar.setForeground(new Color(50, 205, 50));
		progressBar.setBounds(0, 284, 544, 17);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/images/splash screen.jpg")));
		lblNewLabel.setBounds(0, 0, 541, 330);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
	}
}
