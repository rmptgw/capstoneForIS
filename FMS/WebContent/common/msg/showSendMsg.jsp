<%-- 

	메시지 페이지
	
	작성자 : 

	수정일 : 
	
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="script/message.js?ver=2"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지</title>
</head>
<body>
	<jsp:include page="/frame/header.jsp" />
	<c:set var="now" value="<%= new java.util.Date() %>" />
	<div>
		<form method="post" name="showMsgFrm" action="Eu?c=receive_message&no=${message.msgNum}">
			<table border="1" align="center">
				<tr>
					<td colspan="6">
						<h3>메시지 확인</h3>
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<h3>
							${message.msgTitle}<input type="hidden" name="msgTitle" value="${message.msgTitle}">
						</h3>
						(<c:choose>
							<c:when test="${message.empWriter != null}">
								${emp.empName}
								<input type="hidden" name="empWriter" value="${message.empWriter}">
							</c:when>
							<c:when test="${message.freeWriter != null}">
								${free.freeName}
								<input type="hidden" name="freeWriter" value="${message.freeWriter}">
							</c:when>
						</c:choose>
							, ${message.msgSendDate})
					</td>
				</tr>
				<tr>
					<th>발신자</th>
					<td>
						<c:choose>
							<c:when test="${message.empWriter != null}">
								<input type="hidden" name="freeReceiver" value="${message.empWriter}" readonly="readonly">
								${emp.empName}
							</c:when>
							<c:when test="${message.freeWriter != null}">
								<input type="hidden" name="empReceiver" value="${message.freeWriter}" readonly="readonly">
								${free.freeName}
							</c:when>
						</c:choose>
					</td>
					<th>발신일</th>
					<td>
						<input type="hidden" name="msgSendDate" value="${message.msgSendDate}">
						${message.msgSendDate}
					</td>
					<th>수신일</th>
					<td>${message.msgCheckedDate}</td>
				</tr>
				<tr>
					<th>관련 프로젝트</th>
					<td colspan="6">
						<input type="hidden" name="projNum" value="${message.projNum}">
						<input type="text" id="projNum" readonly="readonly" value="${project.projName}">
					</td>
				</tr>
				<tr>
					<td colspan="6">
						<textarea rows="15" cols="90" name="msgContent">${message.msgContent}</textarea>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
	<div>
		<form method="post">
		<table name="prevMassege" border="1" align="center">
			<tr>
				<td colspan="5">
					<h3>보낸 메세지</h3>
				</td>
			</tr>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>수신자</td>
				<td>작성일<!-- 수신일 --></td>
				<td>메세지 확인 여부</td>
			</tr>
			<c:forEach var="message" items="${messageList}" varStatus="status">
				<tr class="record">
					<!-- 번호 -->
					<td>${status.count}</td>
					<!-- 제목 -->
					<td>
						<a href="Eu?c=show_send_message&no=${message.msgNum}&check=${message.msgChecked}&projNo=${message.projNum}">
							${message.msgTitle}
						</a>
					</td>
					<!-- 발신자 -->
					<td>
						<c:choose>
							<c:when test="${message.freeReceiver == null}">
								${message.empReceiver}
							</c:when>
							<c:when test="${message.empReceiver == null}">
								${message.freeReceiver}
							</c:when>
						</c:choose></td>
					<!-- 수신일 / 작성일 -->
					<td>${message.msgSendDate}</td>
					<!-- 메세지 확인 여부 -->
					<td>
						<c:choose>
							<c:when test="${message.msgChecked != '1'}">
								<label>미확인</label>
							</c:when>
							<c:otherwise>
								<label>확인</label>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
		</form>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>