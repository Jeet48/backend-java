package com.hrc;

import java.sql.DriverManager;
import java.sql.Connection;

public class Create_Connection {
	static Connection conn;
	public static Connection cc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user="root";
			String password="12345";
			String url="jdbc:mysql://localhost:3306/grey_goose";
			
			conn=DriverManager.getConnection(url,user,password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
