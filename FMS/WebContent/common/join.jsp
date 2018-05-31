<%-- 

	회원가입 페이지
	
	작성자 : 

	수정일 : 
	
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<!-- <script type="text/javascript" src="js/common.js"/> -->
</head>
<body>
	<jsp:include page="/frame/header.jsp" />
	
	<div align="center">
		<form action="Eu?c=join" method="post" name="frm" onsubmit="return joinCheck()">
			<table border="1" >
				<tr>회원가입</tr>
				<tr>
					<td align="center">아이디</td>
					<td><input type="text" name="fid" placeholder="아이디를 입력해주세요"></td>
				</tr>
				<tr>
					<td align="center">이메일</td>
					<td>
						<input type="text" name="fid_front" placeholder="이메일 앞부분"> @ 
						<input type="text" name="fid_rear" placeholder="이메일의 도메인 주소"></td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td><input type="password" name="fpw" placeholder="비밀번호를 입력해주세요"></td>
				</tr>
				<tr>
					<td align="center">비밀번호 확인</td>
					<td><input type="password" name="refpw" placeholder="비밀번호를 다시 입력해주세요"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="checkbox" name="agree">이용약관 및 개인정보 이용방침에 동의합니다
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="가입완료" onclick="joinCheck()">
						<input type="reset" value="다시입력" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="/frame/footer.jsp"></jsp:include>
</body>
</html>