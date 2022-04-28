package com.saumya.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		MainScreen mainScreen = new MainScreen();
//		mainScreen.setVisible(true);
//	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO SAUMYA'S");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setBounds(52, 23, 668, 120);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CHAT APPLICATION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_1.setBounds(220, 101, 357, 77);
		contentPane.add(lblNewLabel_1);
		
		JButton loginButton = new JButton("Click Here to Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LoginScreen windLoginScreen = new LoginScreen();
			}
		});
		loginButton.setBackground(Color.WHITE);
		loginButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		loginButton.setBounds(161, 203, 445, 66);
		contentPane.add(loginButton);
		
		JButton registerButton = new JButton("Click Here to Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				RegisterScreen window = new RegisterScreen();
			}
		});
		registerButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(161, 304, 445, 66);
		contentPane.add(registerButton);
		setLocationRelativeTo(null);
	}

}
