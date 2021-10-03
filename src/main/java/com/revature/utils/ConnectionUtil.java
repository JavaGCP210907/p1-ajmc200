package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//manage and establish database connection
public class ConnectionUtil {
	//returns object type Connection, to connect to database
	public static Connection getConnection() throws SQLException {
		//For compatibility register our PostgreSQL driver
		//makes the application aware of what Driver class we're using
		try {
			Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); //This tells in the console us what went wrong
			System.out.println("problem occurred locating driver");
		}
		String url = System.getenv("URL");
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");
		return DriverManager.getConnection(url, username, password);
		//Use our database credentials to establish a database connection
		//String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=shield";
		//String username = "postgres";
		//String password = "";	
	}
}
