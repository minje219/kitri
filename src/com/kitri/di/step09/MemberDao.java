 package com.kitri.di.step09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.kitri.di.model.MemberDto;

public class MemberDao {
	
	private DataSource dataSource;
	
	public MemberDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int join(MemberDto memberDto) throws SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = dataSource.getConnection();
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
	
	public MemberDto search(String id) throws SQLException {
		MemberDto memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = dataSource.getConnection();
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






