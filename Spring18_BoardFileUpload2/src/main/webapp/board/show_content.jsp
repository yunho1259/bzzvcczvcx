<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
	function deleteBoard() {
		if(confirm("해당 게시글을 삭제하시겠습니까?")){
			location.href="board.do?command=delete&&no=${bvo.no}";
		}
	}
	function updateBoard() {
		if(confirm("해당 게시글을 수정하시겠습니까?")){
			location.href="board.do?command=updateView&&no=${bvo.no}";
		}
	}
</script>
<body>
	<table cellpadding="5">
		<tr>
		   <td>
		   	    <table width="550">
					<tr>
						<td><b>글번호 : ${requestScope.bvo.no} |
							   타이틀 : ${requestScope.bvo.title}</b>
						<hr style="color: #6691BC; border-style: dotted; margin: 0">
						</td>
					</tr>
					<!-- Fileupload 폼 추가 -->
				    <tr>
				    	<td>파일 : <a href="board.do?command=fileDownload&&newfilename=${bvo.newfilename}&&orgfilename=${bvo.orgfilename}">${bvo.orgfilename}</a></td>
				    </tr>
					<tr>
						<td>작성자 :  ${requestScope.bvo.memberVO.name} |
							작성일시 : ${requestScope.bvo.writeDate}
							Count : ${requestScope.bvo.count}
						</td>
					</tr>
					<tr>
						<td>
						<hr style="color: #6691BC; margin: 0">
						<pre>${requestScope.bvo.content}</pre>					
						</td>
					</tr>
					<tr>
						<td valign="middle">
						<a href="board.do?command=list">					
						<img alt="전체글목록" src="./img/list_btn.jpg" border="0">
						</a>	
						
						<!-- 
							현재 로그인한 사람이 자신이 쓴 게시글을 볼때만 버튼이 보여지도록 한다
							로그인한 사람의 id가 글쓴 사람의 id와 일치할때만 보여지도록...
							c:if을 사용하도록 한다.
						 -->					
						 <c:if test="${mvo.id==bvo.memberVO.id}">				
						<img alt="삭제" src="./img/delete_btn.jpg" border="0" onclick="deleteBoard()">
						<img alt="수정" src="./img/modify_btn.jpg" border="0" onclick="updateBoard()">
						</c:if>	
						</td>
					</tr>
				</table> 	
			</td>
		</tr>
	</table>	
</body>
</html>






























