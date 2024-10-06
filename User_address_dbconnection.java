package com.useraddress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_address_dbconnection {
	
	static final String JDBC_URL = "jdbc:mysql://localhost:3306/addressdb";
	static final String JDBC_USER = "root";
	static final String JDBC_PASSWORD = "";
	
	public static Connection getConnection() throws SQLException {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}
	
	public static void saveAddress(String province, String district, String sector, String cell, String village, String hcc, String residentialArea) {
		String sql = "INSERT INTO addresses(province,district, sector, cell, village, health_care_center, residential)" 
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			//set the values in the preparedStatement
			pstmt.setString(1, province);
			pstmt.setString(2, district);
			pstmt.setString(3, sector);
			pstmt.setString(4, cell);
			pstmt.setString(5, village);
			pstmt.setString(6, hcc);
			pstmt.setString(7, residentialArea);
			
			//execute the update
			int rowInserted = pstmt.executeUpdate();
			if(rowInserted > 0) {
				System.out.println("A new address was inserted successfully!");
				
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		// Example of saving address
		saveAddress("Kigali", "Gasabo","Remera","Nyabisindu","Village A", "Kigali Health Center","nearby");
		
	}

}
