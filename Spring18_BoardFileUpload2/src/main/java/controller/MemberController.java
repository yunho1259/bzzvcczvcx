package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberService;
import model.MemberVO;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MemberController extends MultiActionController{

		private MemberService memberService;

		public void setMemberService(MemberService memberService) {
			this.memberService = memberService;
		}
		public ModelAndView login(HttpServletRequest request,
				HttpServletResponse response, MemberVO pvo)throws Exception{
			MemberVO rvo=memberService.login(pvo);
			
			if(rvo != null){//로그인 성공했다면...
				request.getSession().setAttribute("mvo", rvo);
			}
			//이미 바인딩 됬다..할 필요없다.
			return new ModelAndView("member/login_result");
		}//login
		
		public ModelAndView logout(HttpServletRequest request,
				HttpServletResponse response,HttpSession session)throws Exception{
			
			MemberVO mvo = (MemberVO)session.getAttribute("mvo");
			if(mvo != null)
				session.invalidate();
			return new ModelAndView("redirect:/index.jsp");
		}
		
}


















