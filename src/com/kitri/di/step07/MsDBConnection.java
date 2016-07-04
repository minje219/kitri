package com.kitri.di.step07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MsDBConnection implements DBConnection{

	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
		conn = DriverManager.getConnection("jdbc:sqlserver://192.168.12.100:1433;DatabaseName=dbname", "kitri", "kitri");
		return conn;
	}

}
