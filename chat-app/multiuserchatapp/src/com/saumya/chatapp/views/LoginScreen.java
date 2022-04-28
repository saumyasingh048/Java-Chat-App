package com.saumya.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.saumya.chatapp.dao.UserDAO;
import com.saumya.chatapp.dto.UserDTO;
import com.saumya.chatapp.utils.UserInfo;
import org.apache.log4j.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	Logger logger = Logger.getLogger(LoginScreen.class);
	private JPanel contentPane;
	private JTextField userIDField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginScreen frame = new LoginScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	UserDAO userDAO = new UserDAO();
	
	private void doLogin() {
		logger.debug("doLogin started");
		// TODO Auto-generated method stub
		String userID = userIDField.getText();
		UserInfo.userName = userID;
		// The below written / used method has been deprecated.
		// Reason: Developer could see the end user's Password, which hampered the security of the Application.
//		String password = passwordField.getText();
		char[] password = passwordField.getPassword();
		try {
			UserDTO userDTO = new UserDTO(userID, String.valueOf(password));
			if (userDAO.read(userDTO)) {
				JOptionPane.showMessageDialog(this, "Successfully Logged In...!");
				setVisible(false);
				// to remove from the memory as well.
				dispose();
				Dashboard frame = new Dashboard(userDTO.getUserID());
				frame.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Oops!!! Try Again, Wrong User ID or Password.");
			}
		} catch (NoSuchAlgorithmException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setBounds(349, 45, 121, 59);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(225, 163, 74, 34);
		contentPane.add(lblNewLabel_1);
		
		userIDField = new JTextField();
		userIDField.setBounds(357, 163, 250, 34);
		contentPane.add(userIDField);
		userIDField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_2.setBounds(207, 241, 92, 34);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(357, 243, 250, 34);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(334, 345, 174, 34);
		contentPane.add(btnNewButton);
		setVisible(true);
	}

}
