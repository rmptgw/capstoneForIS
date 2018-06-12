<%-- 

	메인 페이지
	
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
<script type="text/javascript" src="script/common.js"></script>
<title>유레카!</title>
<c:set var="now" value="<%= new java.util.Date() %>" />
</head>
<body>
	<jsp:include page="/frame/header.jsp" />
	<div>
		<table align="center" border="1">
			<tr>
				<td colspan="6"><h3>신규프로젝트</h3></td>
			</tr>
			<tr>
				<td colspan="5">
					<h4>${project.projName}(등록일 : ${project.projRegisterDate})</h4>
				</td>
				<td>
					<c:choose>
						<c:when test="${project.projStartDate > now}"><label>대기중</label></c:when>
						<c:when test="${project.projRecruitEndDate <= now}"><label>진행중</label></c:when>
					</c:choose>
					<c:choose>
						<c:when test="${project.projRecruitEndDate > now}"><label>모집중</label></c:when>
						<c:when test="${project.projRecruitEndDate == now}"><label>당일마감</label></c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>개발분야</th>
				<td>${project.projDevelopSort}</td>
				<th>시작일</th>
				<td><fmt:formatDate value="${project.projStartDate}" pattern="yyyy. MM. dd"/></td>
				<th>예상기간</th>
				<td>${project.projExpectedTime}일</td>
			</tr>
			<tr>
				<th>모집인원</th>
				<td>${project.requirePeople}</td>
				<th>고객사</th>
				<td colspan="3">${project.projTarget}</td>
			</tr>
			<tr>
				<th>언어</th>
				<td>${project.languages}</td>
				<th>DBMS</th>
				<td>${project.dbName}</td>
				<th>TOOL/<br>FRAMEWORK</th>
				<td>${project.frames}</td>
			</tr>
			<tr>
				<td align="right" colspan="7">
					<input type="button" value="자세히보기" onclick="showProjectDetail(${project.projNum})">
				</td>
			</tr>
		</table>
	</div>
	<br>
	<div>
		<table align="center" border="1">
			<tr>
				<th colspan="7">구인 중인 프로젝트</th>
			</tr>
			<tr>
				<th>상태</th>
				<th>프로젝트명</th>
				<th>개발분야</th>
				<th>시작일</th>
				<th>예상기간</th>
				<th>모집마감일</th>
				<th>참여인원</th>
			</tr>
			<c:forEach var="project" items="${projectList}" end="4">
				<tr>
					<td>
						<c:choose>
							<c:when test="${project.projStartDate > now}"><label>대기중</label></c:when>
							<c:when test="${project.projRecruitEndDate <= now}"><label>진행중</label></c:when>
						</c:choose>
						<c:choose>
							<c:when test="${project.projRecruitEndDate > now}"><label>모집중</label></c:when>
							<c:when test="${project.projRecruitEndDate == now}"><label>당일마감</label></c:when>
						</c:choose>
					</td>
					<td>
						<a href="#" onclick="showProjectDetail(${project.projNum})">
							${project.projName}
						</a>
					</td>
					<td>${project.projDevelopSort}</td>
					<td><fmt:formatDate value="${project.projStartDate}" pattern="yyyy. MM. dd"/></td>
					<td>약 ${project.projExpectedTime}일</td>
					<td><fmt:formatDate value="${project.projRecruitEndDate}" pattern="yyyy. MM. dd"/></td>
					<td>${project.joinPeople}&nbsp;/&nbsp;${project.requirePeople}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>