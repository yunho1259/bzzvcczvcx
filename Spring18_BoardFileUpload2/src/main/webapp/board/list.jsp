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
<h2 align="center">All Board List</h2><p>

<table border="2" align="center">
	<tr>
		<th width="10%">번호</th>
		<th width="50%">제목</th>
		<th width="15%">작성자</th>
		<th width="15%">작성일</th>
		<th width="10%">조회수</th>
	</tr>
	<c:forEach items="${list.list}" var="bvo">
		<tr>
			<td>${bvo.no}</td>
			<td><a href="board.do?command=showContent&&no=${bvo.no}">${bvo.title}</a></td>
			<td>${bvo.memberVO.name}</td>
			<td>${bvo.writeDate}</td>
			<td>${bvo.count}</td>
		</tr>
	</c:forEach>
	
	
	
</table>
<p>
<c:if test="${list.pagingBean.previousPageGroup}">
	<a href="board.do?command=list&&pageNo=${list.pagingBean.startPageOfPageGroup-1}"><img alt="" src="img/left_arrow_btn.gif"></a>
</c:if>
<c:forEach begin="${list.pagingBean.startPageOfPageGroup}" end="${list.pagingBean.endPageOfPageGroup}" var="i">
<c:choose>
	<c:when test="${list.pagingBean.nowPage!=i}">
		<a href="board.do?command=list&&pageNo=${i}">${i}</a>
	</c:when>
	<c:otherwise>
		${i}
	</c:otherwise>
</c:choose>
</c:forEach>
<%-- ${list.pagingBean.nextPageGroup}
${list.pagingBean.endPageOfPageGroup}
${list.pagingBean.startPageOfPageGroup}
${list.pagingBean.nowPageGroup}
${list.pagingBean.totalPageGroup}
${list.pagingBean.totalPage} --%>
<c:if test="${list.pagingBean.nextPageGroup}">
	<a href="board.do?command=list&&pageNo=${list.pagingBean.endPageOfPageGroup+1}"><img alt="" src="img/right_arrow_btn.gif"></a>
</c:if>
<div align="center"><a href="index.jsp">Home</a></div>
</body>
</html>














