<%-- 

	헤더
	
	작성자 : 

	수정일 : 
	
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="common/css/style.css">
<link rel="stylesheet" type="text/css" href="common/css/bootstrap.css">
</head>
<body>
	<nav class="navbar navbar-default">
		<div>
		<table>
			<tr>
				<td>
					<a href="Eu?c=main">
						<img class="logo" src="common/img/eureka.PNG"/>
					</a>
				</td>
				<c:choose>
					<%--로그인 상태가 아니면 --%>
					<c:when test="${loginfree == null && loginemp == null}">
						<td>	
							<a href="Eu?c=login">로그인</a> / 
							<a href="Eu?c=join_form">회원가입</a>
						</td>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${loginemp == null}">
								<td><a href="">프로필 등록</a></td>
								<td><a href="">프로젝트 참여신청</a></td>
								<td><a href="Eu?c=show_message">My 페이지</a></td>
								<td>안녕하세요 ${loginfree.freeName}님</td>
							</c:when>
							<c:otherwise>
								<td><a href="">프로젝트 관리</a></td>
								<td><a href="">프리랜서 관리</a></td>
								<td><a href="Eu?c=emp_main">계정 관리</a></td>
								<td><a href="Eu?c=show_message">메세지 확인</a></td>
								<td>안녕하세요 ${loginemp.empName}님</td>
							</c:otherwise>
						</c:choose>
						<td><a href="Eu?c=logout">로그아웃</a></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</div>
	</nav>
	<%-- <c:choose>
	<c:when test="${loginfree == null && loginemp == null}">
		로그인상태 검사
		로그인상태가 아니면 프로필 출력안됨
	</c:when>
	<c:otherwise>
		로그인상태면 미니프로필 받아오면된다
		<jsp:include page="miniprof.jsp"></jsp:include>
	</c:otherwise>
</c:choose> --%>
</body>
</html>
