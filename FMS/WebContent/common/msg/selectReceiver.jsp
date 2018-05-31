<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script/message.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수신자 검색</title>
</head>
<body>
	<form name="selectReceiverFrm" method="post">
		<table>
			<tr>
				<th>번호</th>
				<th>이름</th>
			</tr>
			<c:forEach var="free" items="${freeList}">
				<tr>
					<td>${free.freeId}</td>
					<td>
						<a href="#" onclick="chooseReceiverFree()">
							<input type="hidden" id="freeReceiver" value="${free.freeName}">
							<input type="hidden" id="freeReceiverId" value="${free.freeId}">
							${free.freeName}
						</a>
					</td>
				</tr>
			</c:forEach>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.empId}</td>
					<td>
						<a href="#" onclick="chooseReceiverEmp()">
							<input type="hidden" id="empReceiver" value="${emp.empName}">
							<input type="hidden" id="empReceiverId" value="${emp.empId}">
							${emp.empName}
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>