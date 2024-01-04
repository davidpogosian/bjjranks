package com.bjjranks;

import java.sql.*;

public class Database {
	private Connection connection;

	public Database() {
		/*
		String url = "jdbc:postgresql://localhost/test";
		Properties props = new Properties();
		props.setProperty("user", "david");
		props.setProperty("password", "secret");
		props.setProperty("ssl", "false");
		connection = DriverManager.getConnection(url, props);
		*/
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:postgresql://localhost/test?user=david&password=password&ssl=false";
		try {
			connection = DriverManager.getConnection(url);

		Statement stmt = connection.createStatement();
		String CreateSql = "Create Table NewTable(id int primary key,cname varchar, address text) ";
		stmt.executeUpdate(CreateSql);
		stmt.close();
		connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
