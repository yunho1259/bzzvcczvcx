package controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardService;
import model.BoardVO;
import model.ListVO;
import model.MemberVO;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class BoardController extends MultiActionController{
	private BoardService boardService;
	private String path;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public ModelAndView write(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, BoardVO bvo) throws Exception{
		
		MemberVO mvo=  (MemberVO)session.getAttribute("mvo");
		if(mvo==null){//로그인한 상태가 아니다...글 못쓴다.
			return new ModelAndView("redirect:/index.jsp");
		}
		//mvo를 BoardVo에 꽂아주는 로직을 여기서 작성해야한다.
		//그래야지만 BoardVO와 MemberVO간의 hASING관계가 성립된다.
		
		MultipartFile file = bvo.getUploadFile();
		
		if(!file.isEmpty()){
			bvo.setOrgfilename(file.getOriginalFilename());
			bvo.setNewfilename(System.currentTimeMillis()+"_"+file.getOriginalFilename());
			file.transferTo(new File(path+bvo.getNewfilename()));
		}
		bvo.setMemberVO(mvo);//가장 중요!!!
		boardService.write(bvo);
				
		return new ModelAndView("board/show_content","bvo",bvo);
	}	
	//list
	public ModelAndView list(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		ListVO list=boardService.getBoardList(request.getParameter("pageNo"));
		return new ModelAndView("board/list","list",list);
	}	
	/*
	 * 상세글보기 ::
	 * 목록보기 - 누구나 볼수 있다.
	 * 상세글보기 - 로그인 한 사람만 가능
	 * 삭제,수정하기 - 로그인해 있고 해당글을 작성한 사람만이 가능
	 */
	public ModelAndView showContent(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		MemberVO mvo = (MemberVO)request.getSession().getAttribute("mvo");
		if(mvo==null){//로그인하지 않았다면...
			return new ModelAndView("redirect:/index.jsp");
		}
		
		boardService.updateCount(request.getParameter("no"));
		
		
		BoardVO bvo=boardService.showContent(request.getParameter("no"));
		return new ModelAndView("board/show_content","bvo",bvo);
	}	
	
	public ModelAndView delete(HttpServletRequest request,
			HttpServletResponse response, BoardVO bvo) throws Exception{
		//게시글이 하나 삭제...
		/*String newFileName = request.getParameter("newfilename");
		File file = new File(path+newFileName);
		System.out.println("file : "+file);
		boolean b = file.delete();
		System.out.println("결과 : "+b);*/
		
		String newfilename = request.getParameter("newfilename");
		
		if(newfilename.length()!=0){
			boardService.deleteFile(path+newfilename);
		}
		
		boardService.deleteBoard(request.getParameter("no"));
		
		return new ModelAndView("redirect:/board.do?command=list");
	}	
	//updateView
	public ModelAndView updateView(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		return new ModelAndView("board/update","bvo",boardService.showContent(request.getParameter("no")));
	}	
	
	//updateBoard
	public ModelAndView updateBoard(HttpServletRequest request,
			HttpServletResponse response, BoardVO pvo) throws Exception{
		System.out.println(pvo);
		if(pvo.getNewfilename()==null){
			MultipartFile file = pvo.getUploadFile();
			
			if(!file.isEmpty()){
				pvo.setOrgfilename(file.getOriginalFilename());
				pvo.setNewfilename(System.currentTimeMillis()+"_"+file.getOriginalFilename());
				file.transferTo(new File(path+pvo.getNewfilename()));
			}
		} else{
			boardService.deleteFile(path+request.getParameter("newfilename"));
			MultipartFile file = pvo.getUploadFile();
			
			if(!file.isEmpty()){
				pvo.setOrgfilename(file.getOriginalFilename());
				pvo.setNewfilename(System.currentTimeMillis()+"_"+file.getOriginalFilename());
				file.transferTo(new File(path+pvo.getNewfilename()));
			}
			
		}
		
		boardService.updateBoard(pvo);//디비에서 실질적인 수정이 이뤄짐
		return new ModelAndView("board/show_content","bvo",boardService.showContent(request.getParameter("no")));
	}
	
	// download
	public ModelAndView fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView",map);
	}
	
	// 이 부분에서 디비에서의 파일을 삭제하는 것은 아니다.. 이 부분은 수정시에 발생
	public ModelAndView deleteFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String newfilename = request.getParameter("newfilename");
		System.out.println("ajax...cal...");
		if(newfilename.length()!=0){
			boardService.deleteFile(path+newfilename);
		}
		return new ModelAndView("JsonView");
	}
}














