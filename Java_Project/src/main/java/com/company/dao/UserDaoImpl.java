package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.util.DUBtil;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean isValidUser(String email, String password) {
		String query = "SELECT *FROM users WHERE email = ? AND password = ? ";
		try {
			Connection connection = DUBtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			System.out.println("Query is running"); 
			
			return resultSet.next();
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}

}