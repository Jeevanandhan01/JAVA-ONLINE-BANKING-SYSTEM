package com.jeeva.onlinebankingsystem.databaseconnection;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
	public static Connection provideConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/bankingsystem";
		try {
			conn = DriverManager.getConnection(url,"root","james@5,7373");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured while connecting to database");
		}
		return conn;
	}
	
}
