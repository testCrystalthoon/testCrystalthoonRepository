<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>[ springWeb5 - SE Bank Step 4 ]</h1>
<br>

<ul>
	<c:choose>
		<c:when test="${id != null }">
<pre><h3><c:out value="${id }(${name })"/>님 로그인 중</h3></pre>
			<li><a href="logout">로그아웃</a></li>
			<li><a href="updateForm">개인정보 수정</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="joinForm">회원 가입</a></li>
			<li><a href="loginForm">로그인</a></li>
		</c:otherwise>
	</c:choose>
	<li><a href="boardlist">게시판</a></li>
</ul>

</body>
</html>
