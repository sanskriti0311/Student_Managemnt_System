package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static String driver ="com.mysql.cj.jdbc.Driver";
	
	private static String url ="jdbc:mysql://localhost:3306/jdbc_db";
	private static String user="root";
	private static String pass="s@ns11";
	
	private static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(con == null) {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
		}
		return con;
	}
}
