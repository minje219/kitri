package com.kitri.di.step05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kitri.di.model.MemberDto;

public class MemberMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DBConnection dbc=new OraDBConnection();
		MemberDao memberDao = new MemberDao(dbc);
		MemberDto memberDto = new MemberDto();
		memberDto.setId("minje219");
		memberDto.setName("�����");
		
		int cnt = memberDao.join(memberDto);
		System.out.println("�Է� " + (cnt != 0 ? "����!!!" : "����!!!"));
		
		String sid = "minje219";
		MemberDto sdto = memberDao.search(sid);
		if(sdto != null) {
			System.out.println("�̸� : " + sdto.getName());
			System.out.println("���̵� : " + sdto.getId());
			System.out.println("������ : " + sdto.getJoindate());
		}
	}
}


