package model;

import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDao {
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public MemberVO login(MemberVO vo)throws SQLException{
		return sqlSession.selectOne("memberSql.login",vo);
	}
}










