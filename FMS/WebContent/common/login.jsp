<%-- 

	로그인 페이지
	
	작성자 : 박태근

	수정일 : 20180506
	
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<jsp:include page="/frame/header.jsp"/>
	<div align="center">
		로그인
		<form action="Eu?c=login_form" method="post">
			<table border="1">
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<input type="text" name="feid" id="feid" placeholder="아이디">
								</td>
								<td rowspan="2">
									<input type="submit" value="로그인">
								</td>
							</tr>
							
							<tr>
								<td>
									<input type="password" name="fepw" id="fepw" placeholder="비밀번호">
								</td>
							</tr>
							
							<tr>
								<td colspan = "2">
									<a href="">아이디</a>/
									<a href="">비밀번호찾기</a>&nbsp;|&nbsp;
									<a href="Eu?c=join_form">회원가입</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>EUREKA!는프리랜서 관리시스템 입니다.</td>
				</tr>
			</table>
		</form>
	</div>
<jsp:include page="/frame/footer.jsp"></jsp:include>
</body>
</html>