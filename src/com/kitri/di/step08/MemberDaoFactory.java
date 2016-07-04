package com.kitri.di.step08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberDaoFactory {

	private MemberDao memberDao;
	
	@Bean(name={"mdao","memberDao"}, initMethod="init ")
	//@Scope(value="prototype")
	public MemberDao getMemberDao() {
		memberDao = new MemberDao(getOraDBConnection());
		return memberDao;
	}
	
	public DBConnection getOraDBConnection() {
		return new OraDBConnection();
	}
	
	public DBConnection getMsDBConnection() {
		return new MsDBConnection();
	}
	
}
