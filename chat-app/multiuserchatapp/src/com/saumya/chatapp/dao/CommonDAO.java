package com.saumya.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// using static import
import static com.saumya.chatapp.utils.configReader.getValue;

interface CommonDAO {
	// Static Methods allowed since JAVA - 8
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		// Step - 1: Load a driver, which is very similar to loading a class.
//		Class.forName("com.mysql.cj.jdbc.Driver");
		Class.forName(getValue("DRIVER"));
		// If the above mentioned class is not found, ClassNotFoundException will be thrown.
		// Step - 2: Making a Connection
//		final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/chatdb";
		final String CONNECTION_STRING = getValue("CONNECTION_STRING");
//		final String USER_ID = "root";
		final String USER_ID = getValue("USER_ID");
//		final String PASSWORD = "root";
		final String PASSWORD = getValue("PASSWORD");
		Connection connection = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
//		if (connection != null) {
//			System.out.print("Connection Created Successfully...");
//			connection.close();
//		}
		return connection;
	}
	
}
