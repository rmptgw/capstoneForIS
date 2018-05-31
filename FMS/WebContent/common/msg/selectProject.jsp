<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프로젝트 선택</title>
</head>
<body>
		<table align="center" border="1">
			<tr>
				<th>번호</th>
				<th>프로젝트 이름</th>
			</tr>
		<c:forEach var="joinProj" items="${joinProjList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>
					<a href="#" onclick="chooseProject()">
						<input type="hidden" name="projNum" id="projNum" value="${joinProj.projNum}">
						${joinProj.projNum}
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>