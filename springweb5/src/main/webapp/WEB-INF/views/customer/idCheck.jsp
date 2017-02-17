<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<script src="./resources/js/function.js"></script>
</head>
<body>
<h1>[ ID 중복 확인 ]</h1>
<form action="searchId" method="post" onsubmit="return searchId()">
	<input type="text" name="id" id="id" placeholder="검색할 ID 입력" value="${searchId }">
	<input type="submit" value="검색">
</form>
	<%
		String method = request.getMethod();
		if(method.equals("POST")) {
	%>
		<c:choose>
			<c:when test="${searchResult  == null}">
				${searchId } : 사용할 수 있는 ID입니다.<br>
				<input type="button"  value="ID사용하기" onclick="useThisId('${searchId }')"> <!-- 숫자는 ''가 필요없지만 문자는 ''를 해줘야 한다. -->
			</c:when>
			<c:otherwise>
				${searchId } : 이미 사용중인 ID입니다.
			</c:otherwise>
		</c:choose>
	<%
		}
	%>
	

</body>
</html>