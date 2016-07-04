package com.kitri.di.step04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain {

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


