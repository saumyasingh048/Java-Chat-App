package com.saumya.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// This class: UserView will help to create a screen which will be having - 
// minimize, maximize and cross operations.

// To generate / create a screen, the class needs to extend JFrame.
public class UserView extends JFrame{
	int counter;
	// Default Constructor
	public UserView() {
		counter = 0;
		// To show the JFrame
		setVisible(true);
		// To Exit Completely
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Sets the size
		setSize(400, 400);
		// Sets the Location of JFrame
		setLocation(500, 200);
		// To Locate the JFrame in the Center of the screen
		setLocationRelativeTo(null);
		// To stop Resize functionality
//		setResizable(false);
		// To Set the title
		setTitle("Login");
		// Want the heading / Label as Login
		JLabel loginPageHeading = new JLabel("Login");
		// Setting the font
		Font font = new Font("Arial", Font.BOLD, 40);
		loginPageHeading.setFont(font);
		// Logic to add the label to the content pane
		Container container = this.getContentPane();
		container.setLayout(null);
		loginPageHeading.setBounds(100, 70, 150, 50);
		container.add(loginPageHeading);
		// Adding Button
		JButton btn = new JButton("Click Me");
		btn.setBounds(100, 130, 150, 50);
		container.add(btn);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				counter++;
				btn.setText("Val: " + counter);
			}
		});
	}
	public static void main(String[] args) {
		UserView userView = new UserView();
	}
}
