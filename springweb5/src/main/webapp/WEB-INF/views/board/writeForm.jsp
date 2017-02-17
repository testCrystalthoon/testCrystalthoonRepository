<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="write" method="post">
	<table>
		<tr>
			<th>제목</th>
			<td><input type="text" id="title" name="title"></td>
		</tr>
		<tr>
			<th>본문</th>
			<td><textarea rows="3" cols="3" name="content"></textarea></td>
		</tr>
		<input type="submit" value="저장">
	</table>	
</form>
</body>
</html>