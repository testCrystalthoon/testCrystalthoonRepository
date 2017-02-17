<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>[ 개인 정보 수정 ]</h1>
<form action="update" method="post" onsubmit="formCheck()">
	<table>
		<tr>
			<th class="title">ID</th>
			<td><input type="text" name="id" id="id" placeholder="ID중복확인 이용" readonly="readonly" value="${member.id }"></td>
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
			<td><input type="text" name="name" placeholder="이름 입력" value="${member.name }"></td>
		</tr>
		<tr>
			<th class="title">이메일</th>
			<td><input type="text" name="email" placeholder="이메일 입력" value="${member.email }"></td>
		</tr>
		<c:choose>
			<c:when test="${member.division=='personal' }">
				<tr>
					<th class="title">고객구분</th>
					<td>개인<input type="radio" name="division" value="personal" checked="checked">
					기업<input type="radio" name="division" value="company"></td>
				</tr>
			</c:when>
			<c:when test="${member.division=='company' }">
				<tr>
					<th class="title">고객구분</th>
					<td>개인<input type="radio" name="division" value="personal">
					기업<input type="radio" name="division" value="company" checked="checked"></td>
				</tr>
			</c:when>
		</c:choose>
		<tr>
			<th class="title">식별번호</th>
			<td><input type="text" name="idno" placeholder="개인:주민번호 / 법인:사업자번호" value="${member.idno }"></td>
		</tr>
		<tr>
			<th class="title">주소</th>
			<td colspan=3><input type="text" name="address" style="width: 98%;" placeholder="주소 입력" value="${member.address }"></td>
		</tr>
		<th></th>
		<td align="center">
			<input type="submit" value="수정">
			<input type="reset" value="다시 쓰기">
		</td>
		</tr>
	</table>
	<br>
</form>

</body>
</html>