<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>

<link href="./resources/css/web5.css" rel="stylesheet" type="text/css">
<script src="./resources/js/function.js"></script>
</head>
<body>
<h1>[ 회원 가입 ]</h1>
<form action="join" method="post" onsubmit="formCheck()">
	<table>
		<tr>
			<th class="title">ID</th>
			<td><input type="text" name="id" id="id" placeholder="ID중복확인 이용" readonly="readonly" value="${member.id }"></td>
			<td><input type="button" onclick="idCheck()" value="ID중복확인"></td>
		</tr>
		<tr>
			<th rowspan=2 class="title">비밀번호</th>
			<td><input type="password" name="password" placeholder="비밀번호 입력"></td>
		</tr>
		<tr>
			<td><input type="password"  name="password1" placeholder="비밀번호 다시 입력"></td>
		</tr>
		<tr>
			<th class="title">이름</th>
			<td><input type="text" name="name" placeholder="이름 입력"></td>
		</tr>
		<tr>
			<th class="title">이메일</th>
			<td><input type="text" name="email" placeholder="이메일 입력"></td>
		</tr>
		<tr>
			<th class="title">고객구분</th>
			<td>개인<input type="radio" name="division" value="personal" checked="checked">
			기업<input type="radio" name="division" value="company"></td>
		</tr>
		<tr>
			<th class="title">식별번호</th>
			<td><input type="text" name="idno" placeholder="개인:주민번호 / 법인:사업자번호"></td>
		</tr>
		<tr>
			<th class="title">주소</th>
			<td colspan=3><input type="text" name="address" style="width: 98%;" placeholder="주소 입력"></td>
			
		</tr>
		<th></th>
		<td align="center">
			<input type="submit" value="가입">
			<input type="reset" value="다시 쓰기">
		</td>
		</tr>
	</table>
	<br>
</form>
</body>
</html>