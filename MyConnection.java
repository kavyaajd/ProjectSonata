package com.web.resort.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection 
{
	
		private static Connection connection;
		private MyConnection() {}
		public static Connection getConnection() throws SQLException, ClassNotFoundException
		{
			if(connection==null)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/resort","root","Kav@9845093184");
			}
			return connection;
			}
	}

