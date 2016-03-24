package br.com.unorte.ufarm.Activity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaSql {
	
	private static final String URL = "jdbc:mysql://unorte.com.br/";
	private static final String USER = "unorteco_admin";
	private static final String PASS = "4nJQfp6n25";
	
	public Connection Connect(String banco) throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL.trim() + banco.trim(), USER.trim(), PASS.trim());
		
	}
}
