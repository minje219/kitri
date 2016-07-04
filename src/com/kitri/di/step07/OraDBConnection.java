package com.kitri.di.step07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OraDBConnection implements DBConnection{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl", "kitri", "kitri");
			
			return conn;
		
	}

	
	
}
