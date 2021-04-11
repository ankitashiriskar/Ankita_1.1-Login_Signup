package com.login.register;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection implements ConnInterface{ 

	static Connection con = null;

	public static Connection getCon() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(jdbcURL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
