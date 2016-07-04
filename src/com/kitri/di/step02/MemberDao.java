package com.kitri.di.step02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberDao {
	
	public int join(MemberDto memberDto) throws ClassNotFoundException, SQLException {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = makeConnection();
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
		conn = makeConnection();
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

	private Connection makeConnection() throws ClassNotFoundException, SQLException {

		Connection conn;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.100:1521:orcl", "kitri", "kitri");
		return conn;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId("minje219");
		memberDto.setName("김민재");
		
		int cnt = memberDao.join(memberDto);
		System.out.println("입력 " + (cnt != 0 ? "성공!!!" : "실패!!!"));
		
		String sid = "minje219";
		MemberDto sdto = memberDao.search(sid);
		if(sdto != null) {
			System.out.println("이름 : " + sdto.getName());
			System.out.println("아이디 : " + sdto.getId());
			System.out.println("가입일 : " + sdto.getJoindate());
		}
	}
	
}






