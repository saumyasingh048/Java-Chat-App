package com.saumya.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.saumya.chatapp.dto.UserDTO;

// Do CRUD Operations

public class UserDAO {
	public boolean read(UserDTO userDTO) throws SQLException, ClassNotFoundException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// Writing query becomes easier using PreparedStatement as we get hold of Place holders.
		final String query = "select UserID from users where USerID=? and Password=?;";		
		try {
			// Establish the connection.
			connection = CommonDAO.createConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userDTO.getUserID());
			preparedStatement.setString(2, userDTO.getPassword());
			resultSet = preparedStatement.executeQuery();
			return resultSet.next();
		}
		// Close all the resources which you have opened above.
		finally {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

//		preparedStatement.
//		preparedStatement.executeQuery(1, )
	}
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		System.out.println("Received" + userDTO.getUserID() + userDTO.getPassword());
		Connection connection = null;
		Statement statement = null;
		try {
		// Step - 1: To create a Connection
		connection = CommonDAO.createConnection();
		statement = connection.createStatement();
		int record = statement.executeUpdate("insert into users (UserID, Password, EmailID, PhoneNo, City, Name) values ('" + userDTO.getUserID() + "', '" + new String(userDTO.getPassword()) + "', '" + userDTO.getEmailID() + "', '" + userDTO.getPhoneNo() + "', '" + userDTO.getCity() + "', '" + userDTO.getName() + "');");
		return record;
		// This return will be executed later, first, finally block will be executed.
		// if there comes a statement - System.exit(), i.e., program is terminated, in that case finally block will not be executed.
//		System.exit(record);
		}
		finally {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
		}
	}
}
