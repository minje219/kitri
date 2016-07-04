package com.kitri.di.step06;

public class MemberDaoFactory {

	private MemberDao memberDao;
	
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
