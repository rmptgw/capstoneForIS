<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script/interview.js?ver=1" charset="UTF-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="common/css/style.css">
<title>면접일 지정</title>
</head>
<body>
<c:set var="now" value="<%= new java.util.Date() %>" />
<div>
	<form method="post" name="frm">
		<table align="center" >
			<tr>
				<td>
					<img class="logo" src="common/img/eureka.PNG"/>
				</td>
				<th colspan="3" align="right">면접일 지정</th>
			</tr>
			<tr>
				<th>날짜</th>
				<td><input type="date" name="interviewDate" id="date"></td>
				<th>시간</th>
				<td><input type="time" name="interviewTime" id="time"></td>
			</tr>
			<tr>
				<th>장소</th>
				<td colspan="3">
					<input type="text" name="location" id="location">
				</td>
			</tr>
			<tr>
				<th>알림말</th>
				<td colspan="3">
					<textarea name="content" rows="10" cols="50" id="content" ></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					
					<c:forEach var="join" items="${joinProjList}">
						<input type="hidden" name="joinNum" value="${join.joinNum}">
					</c:forEach>
					
					<input type="submit" value="확인" onclick="sendAppointmentMsg(); return false;">
					<input type="button" value="취소" onclick="self.close();">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>