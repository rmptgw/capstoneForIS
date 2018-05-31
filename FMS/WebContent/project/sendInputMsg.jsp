<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>투입 메시지</title>
<link rel="stylesheet" type="text/css" href="common/css/style.css">
</head>
<body>
<c:set var="now" value="<%= new java.util.Date() %>" />
	<div>
		<form action="Eu?e=send_input_message" method="post" name="frm">
			<table align="center" border="1">
				<tr>
					<th colspan="4">
						<img class="logo" src="common/img/eureka.PNG"/>
						투입요청보내기
					</th>
				</tr>
				<tr>
					<th>발신인</th>
					<td><input type="text" name="empWriter" readonly="readonly"></td>
					<th>발신일</th>
					<td><fmt:formatDate value="${now}"/></td>
				</tr>
				<tr>
					<th>프로젝트명</th>
					<td colspan="3">
						<input type="text" name ="projNum" value="${message.projName}">
					</td>
				</tr>
				<tr>
					<th>수신인</th>
					<th colspan="2">투입일</th>
					<th></th>
				</tr>
				<c:forEach var="sendMsg" items="sendInputFreeList">
					<tr>
						<td>
							<input type="text" value="${sendMsg.freeId}">
						</td>
						<td>
							<input type="date" name = "joinDate">~
						</td>
						<td>
							<input type="date" name = "dropDate">
						</td>
						<td>
							<input type="button" name="" value="요청전송" onclick="">
							<input type="button" name="input" value="투입" onclick="">
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="center">
						<input type="submit" value="확인">
						<input type="button" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>