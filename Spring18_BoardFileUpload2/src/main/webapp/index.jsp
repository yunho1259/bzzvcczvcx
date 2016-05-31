<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout(){
		var f=confirm("로그아웃 하시겠습니까?");
		if(f)
			location.href="member.do?command=logout"; //Controller에서 기능으로 연결..
	}
</script>
</head>
<body>
<h2 align="center">Spring MVC 게시판 :: Board Update 3.</h2><p>

<c:choose>
<c:when test="${sessionScope.mvo==null}">
	<form method="post" action="member.do">
		<input type="hidden" name="command" value="login">
		ID :<input type="text" name="id"><p>
		PASS :<input type="password" name="password"><p>
		<input type="submit" value="로그인">
	</form><p>
</c:when>
<c:otherwise>
${sessionScope.mvo.name} 님은 로그인 상태입니다..<br><br>
<a href="javascript:logout()">로그아웃</a><p><hr>
<a href="board/write.jsp"><img alt="게시판 글쓰기" src="img/write_btn.jpg" border="0"></a>
</c:otherwise>
</c:choose>

<a href="board.do?command=list"><img alt="게시판 목록" src="img/list_btn.jpg" border="0"></a>
</body>
</html>




























