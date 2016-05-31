package model;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

public class BoardService {
	private BoardDao boardDao;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	public void write(BoardVO bvo) throws SQLException{
		System.out.println("Before No 확인 :: "+bvo.getNo()); //0
		boardDao.write(bvo);//시퀀스가 증가됬고..그게 이미 vo에 박혔다.
		System.out.println("After No 확인 :: "+bvo.getNo()); //11,
		String date = boardDao.selectByNoForDate(bvo.getNo());
		
		bvo.setWriteDate(date);
	}
	
	public ListVO getBoardList(String pageNo)throws SQLException{
		 //목록 버튼에서 전체글보기로 들어간경우
		//특정한 페이지를 선택하지 않았다면...바로 최신페이지 1페이지로 들어간다
		if(pageNo==null || pageNo=="")	pageNo = "1";
		PagingBean pb = new PagingBean(boardDao.totalCount(), Integer.parseInt(pageNo));
		ListVO lvo = new ListVO();
		lvo.setList(boardDao.getBoardList(pageNo));
		lvo.setPagingBean(pb);
		return lvo;
	}
	
	public BoardVO showContent(String no)throws SQLException{
		return boardDao.showContent(no);
	}
	
	public void deleteBoard(String no)throws SQLException{
		boardDao.deleteBoard(no);		
	}
	
	public void updateCount(String no)throws SQLException{
		boardDao.updateCount(no);
	}
	
	public void updateBoard(BoardVO bvo)throws SQLException{
		boardDao.updateBoard(bvo);
	}
	
	public void totalCount()throws SQLException{
		boardDao.totalCount();
	}
	
	// 여기다 하나 더 추가.. 파일 삭제 기능.. (DB와 연관 없다)
	// upload폴더에 있는 new filename을 삭제하는 기능
	public void deleteFile(String newfilename) {
		File file = new File(newfilename); // path는 뺀다.
		
		System.out.println(newfilename+"... file delete ok !!"+file.delete());
	}
}











