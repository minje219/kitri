package com.kitri.di.step08;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kitri.di.model.MemberDto;

public class MemberMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(MemberDaoFactory.class);
		MemberDao memberDao = context.getBean("mdao",MemberDao.class);
		MemberDao memberDao2 = context.getBean("mdao",MemberDao.class);
		
		
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


