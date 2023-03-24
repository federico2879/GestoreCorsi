package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() throws SQLException{
		
		String jbdcURL = "jdbc:mariadb://localhost/iscritticorsi?user=root&password=Armadio2005.";
		Connection conn =  DriverManager.getConnection(jbdcURL);
		return conn;
	}

}
