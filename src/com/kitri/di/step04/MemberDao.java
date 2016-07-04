package com.kitri.di.step04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberDao {
	
	private DBConnection dbc;
	
	public MemberDao() {
		dbc = new DBConnection();
	}
	
	public int join(MemberDto memberDto) throws ClassNotFoundException, SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dbc.makeConnection();
		String sql = "insert into springtest (id, name, joindate) \n";
		sql += "values (?, ?, sysdate)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberDto.getId());
		pstmt.setString(2, memberDto.getName());
		cnt = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return cnt;
	}
	
	public MemberDto search(String id) throws ClassNotFoundException, SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = dbc.makeConnection();
		String sql = "select * \n";
		sql += "from springtest \n";
		sql += "where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			memberDto = new MemberDto();
			memberDto.setId(rs.getString("id"));
			memberDto.setName(rs.getString("name"));
			memberDto.setJoindate(rs.getString("joindate"));
		}
		rs.close();
		pstmt.close();
		conn.close();
		return memberDto;
	}


	
}






