<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
<h1>[ 로그인 ]</h1>
<form action="login" method="post" onsubmit="return loginCheck()">
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="id" name="id"></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><input type="password" id="password" name="password"></td>
		</tr>
	</table>
	<input type="submit" value="Login">
</form>
<c:if test="${loginErr != null }">
	${loginErr }
</c:if>


</body>
</html>