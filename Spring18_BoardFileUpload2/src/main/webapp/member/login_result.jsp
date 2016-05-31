<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- session에서 찾아온 정보..mvo가 null인지 안니지에 따라서 갈라진다. -->
<c:choose>
	<c:when test="${mvo==null}">
		<script type="text/javascript">
			alert("로그인 실패!!");
			location.href="index.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("${mvo.name} 님, 로그인 성공!!");
			location.href="index.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>




















