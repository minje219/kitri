package com.kitri.di.step10;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class MemberDaoFactory {

	private MemberDao memberDao;
	
	@Bean(name={"mdao","memberDao"}, initMethod="init ")
	//@Scope(value="prototype")
	
	public MemberDao getMemberDao() {
		memberDao = new MemberDao();
		memberDao.setDataSource(getDataSource());
		
		return memberDao;
	}
	
	private DataSource getDataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class);
		dataSource.setUrl("jdbc:oracle:thin:@192.168.12.100:1521:orcl");
		dataSource.setUsername("kitri");
		dataSource.setPassword("kitri");
		return dataSource;
	}
	
}
