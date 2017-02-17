<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<a href="boardWriteForm">글쓰기 폼 이동</a>
	<table border="1">
		<tr>
			<td>작성자</td>
			<td>글제목</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="boardmap" items="${boardlist }">
			<tr>
				<td>${boardmap["NAME"] }</td>
				<td><a href="read?boardnum="${boardmap["BOARDNUM"] }>${boardmap["TITLE"] }</a></td>
				<td>${boardmap["INPUTDATE"] }</td>
				<td>${boardmap["HITS"] }</td>
			</tr>
		</c:forEach>
	</table>
<a href="./">홈으로</a>
</body>
</html>