package com.saumya.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.saumya.chatapp.dao.UserDAO;
import com.saumya.chatapp.dto.UserDTO;



public class RegisterScreen extends JFrame{
	private JTextField userIDTextField;
	private JPasswordField passwordField;

	

//	
//	public static void main(String[] args) {
//		
//					UserScreen window = new UserScreen();
//		
//		
//	}
	
	UserDAO userDAO = new UserDAO();
	private JTextField emailField;
	private JTextField phoneNoField;
	private JTextField cityField;
	private JTextField nameField;
	
	// Clear all the Selections
	private void clearSelection() {
		// TODO Auto-generated method stub
//		userIDTextField.setText() = null;
		userIDTextField.setText(null);
		nameField.setText(null);
		emailField.setText(null);
		phoneNoField.setText(null);
		passwordField.setText(null);
		cityField.setText(null);
		
	}
	
	
	private void registerDetails() {
		String userID = userIDTextField.getText();
		// The below written / used method has been deprecated.
		// Reason: Developer could see the end user's Password, which hampered the security of the Application.
//		String password = passwordField.getText();
		char[] password = passwordField.getPassword();
		// To get User's Name
		String name = nameField.getText();
		// To get User's Email ID
		String emailID = emailField.getText();
		// To get User's City
		String city = cityField.getText();
		// To get User's Phone No.
		BigInteger phoneNo = new BigInteger(phoneNoField.getText());
//		UserDAO userDAO = new UserDAO();
		try {
			UserDTO userDTO = new UserDTO(userID, String.valueOf(password), name, emailID, city, phoneNo);
			int result = userDAO.add(userDTO);
			if (result > 0) {
//				System.out.println("Record Successfully Added");
				JOptionPane.showMessageDialog(this, "Record Successfully Added");
			}
			else {
//				System.out.println("Oops !!! Record can't be Added");
				JOptionPane.showMessageDialog(this, "Oops !!! Record can't be Added");
			}
		}
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Algorithm Mentioned");
			e.printStackTrace();
		}
		catch (ClassNotFoundException | SQLException exception) {
			System.out.println("Some Database Issue");
			exception.printStackTrace();
		}
		catch (Exception exception) {
			System.out.println("Some Generic Exception");
			exception.printStackTrace();
		}
		
		System.out.println("User ID: " + userID + " Password: " + password + " Text Password: " + String.valueOf(password));
	}
	
	public RegisterScreen() {
		// Setting title of the JFrame
		setTitle("Registration Page");
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 16));
		// Border Layout to Absolute
		getContentPane().setLayout(null);
		
		userIDTextField = new JTextField();
		userIDTextField.setBackground(SystemColor.inactiveCaptionBorder);
		userIDTextField.setBounds(67, 288, 254, 24);
		getContentPane().add(userIDTextField);
		userIDTextField.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("Register");
		lblNewLabel1.setForeground(Color.DARK_GRAY);
		lblNewLabel1.setBackground(Color.MAGENTA);
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel1.setBounds(336, 31, 155, 52);
		getContentPane().add(lblNewLabel1);
		
		JLabel lblNewLabel3 = new JLabel("Password");
		lblNewLabel3.setForeground(Color.DARK_GRAY);
		lblNewLabel3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel3.setBounds(513, 236, 89, 24);
		getContentPane().add(lblNewLabel3);
		
		JLabel lblNewLabel2 = new JLabel("User ID");
		lblNewLabel2.setForeground(Color.DARK_GRAY);
		lblNewLabel2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel2.setBounds(67, 236, 74, 24);
		getContentPane().add(lblNewLabel2);
		
		
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerDetails();
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRegister.setBounds(214, 491, 142, 35);
		getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.inactiveCaptionBorder);
		passwordField.setBounds(513, 288, 254, 24);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel4 = new JLabel("Email ID");
		lblNewLabel4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel4.setForeground(Color.DARK_GRAY);
		lblNewLabel4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel4.setBounds(513, 128, 77, 24);
		getContentPane().add(lblNewLabel4);
		
		emailField = new JTextField();
		emailField.setBackground(SystemColor.inactiveCaptionBorder);
		emailField.setBounds(513, 173, 254, 24);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setVerticalAlignment(SwingConstants.TOP);
		lblPhoneNo.setForeground(Color.DARK_GRAY);
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhoneNo.setBounds(513, 359, 101, 24);
		getContentPane().add(lblPhoneNo);
		
		phoneNoField = new JTextField();
		phoneNoField.setBackground(SystemColor.inactiveCaptionBorder);
		phoneNoField.setColumns(10);
		phoneNoField.setBounds(513, 411, 254, 24);
		getContentPane().add(phoneNoField);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setVerticalAlignment(SwingConstants.TOP);
		lblCity.setForeground(Color.DARK_GRAY);
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCity.setBounds(67, 359, 101, 24);
		getContentPane().add(lblCity);
		
		cityField = new JTextField();
		cityField.setBackground(SystemColor.inactiveCaptionBorder);
		cityField.setColumns(10);
		cityField.setBounds(67, 411, 254, 24);
		getContentPane().add(cityField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setForeground(Color.DARK_GRAY);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setBounds(67, 128, 101, 24);
		getContentPane().add(lblName);
		
		nameField = new JTextField();
		nameField.setBackground(SystemColor.inactiveCaptionBorder);
		nameField.setColumns(10);
		nameField.setBounds(67, 173, 254, 24);
		getContentPane().add(nameField);
		
		JButton btnNewButton_1 = new JButton("Reset Form");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearSelection();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(440, 491, 182, 35);
		getContentPane().add(btnNewButton_1);
		setSize(846, 631);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
