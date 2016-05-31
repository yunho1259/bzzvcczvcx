package model;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class BoardDao {
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	














	public int write(BoardVO bvo) throws SQLException{
		return sqlSession.insert("boardSql.write", bvo);
	}
	
	public String selectByNoForDate(int no) throws SQLException{
		return sqlSession.selectOne("boardSql.selectByNoForDate",no);
	}
	
	public List<BoardVO> getBoardList(String no) throws SQLException{
		return sqlSession.selectList("boardSql.getBoardList", no);
	}
	
	public BoardVO showContent(String no) throws SQLException{
		return sqlSession.selectOne("boardSql.showContent", no);
	}
	
	public void deleteBoard(String no) throws SQLException{
		sqlSession.delete("boardSql.deleteBoard", no);
	}
	
	public void updateCount(String no)throws SQLException{
		sqlSession.update("boardSql.updateCount", no);
	}
	
	public void updateBoard(BoardVO bvo)throws SQLException{
		sqlSession.update("boardSql.updateBoard", bvo);
	}
	
	public int totalCount()throws SQLException{
		return sqlSession.selectOne("boardSql.totalCount");
	}
}












