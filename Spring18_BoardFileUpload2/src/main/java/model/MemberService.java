package model;

import java.sql.SQLException;

public class MemberService {
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public MemberVO login(MemberVO vo) throws SQLException{
		return memberDao.login(vo);
	}
}
