package com.bjjranks;

import java.sql.*;

import java.util.Properties;

public class Database {
	private Connection connection;

	public Database() {		
		loadDriver();
	}

	private void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void connect() {
		try {
			String url = "jdbc:postgresql://localhost/test";
			Properties props = new Properties();
			props.setProperty("user", "david");
			props.setProperty("password", "password");
			props.setProperty("ssl", "false");
			connection = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void reset() {
		try {
			System.out.println("Reseting Database.");
			connect();
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS newtable");
			stmt.executeUpdate("CREATE TABLE newtable(id int primary key, cname varchar, address text)");
			stmt.close();
			disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() throws SQLException {
		connection.close();
	}
}
