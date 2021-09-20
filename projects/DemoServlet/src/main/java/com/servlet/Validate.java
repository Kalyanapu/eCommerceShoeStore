package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Validate {
	public static boolean checkUser(String  Empnames) {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "java",
					"password");
			Statement statement = connection.createStatement();
			String sql = "select *from Employee where Empname='Empnames'";
			statement.execute(sql);
			System.out.println("Employee found");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
