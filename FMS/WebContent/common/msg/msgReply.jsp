<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메세지 답장</title>
</head>
<body>
<c:set var="now" value="<%= new java.util.Date() %>" />
	<form action="Eu?c=message" method="post" name="frm">
		<table name="newMessage" border="1" align="center">
			<tr>
				<td colspan="6">
					<h3>새로운&nbsp;메세지</h3>
				</td>
			</tr>
			<tr>
				<td colspan="6"><h3>${message.title}</h3>(${message.writer}, ${message.msgSendDate}) <%-- <h3>${message.title}</h3>
				(<h6>${message.writer1}&nbsp;${message.regDate}</h6>) --%>
				</td>
			</tr>
			<tr>
				<th>발신자</th>
				<td>
					<c:choose>
						<c:when test="${loginemp == null}">
							<input type="text" id="writer" value="${loginfree.freeName}" readonly="readonly">
						</c:when>
						<c:when test="${loginfree == null}">
							<input type="text" id="writer" value="${loginemp.empName}" readonly="readonly">
						</c:when>
					</c:choose>
				</td>
				<th>발신일</th>
				<td>${message.msgSendDate}</td>
				<th>수신일</th>
				<td>
					<fmt:formatDate value="${now}"/>
				</td>
			</tr>
			<tr>
				<th>관련 프로젝트</th>
				<td colspan="5">
					<label id="projectName" value="">
					<input type="button" onclick="">
				</td>
			</tr>
			<tr>
				<td colspan="6"><textarea rows="15" cols="50">${message.content}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="6" align="right"><input type="submit" value="답글쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>