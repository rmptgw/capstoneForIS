<%-- 

	메인 페이지
	
	작성자 : 

	수정일 : 
	
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="ccm.dao.CommonDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="common/css/bootstrap.css">
<title>유레카!</title>
</head>
<body>
	<jsp:include page="/frame/header.jsp" />
	<div>
		<table align="center" border="1">
			<tr>
				<td colspan="7"><h3>신규프로젝트</h3></td>
			</tr>
				<td>
					<tr>
						<th>개발분야</th>
						<td><%-- ${project.projDevelopSort} --%></td>
						<th>시작일</th>
						<td><%-- ${project.projStartDate} --%></td>
						<th>예상기간</th>
						<td><%-- ${project.projExpectedTime} --%></td>
						<td></td>
					</tr>
					<tr>
						<th>참여인원</th>
						<td></td>
						<th>고객사</th>
						<td colspan="3"><%-- ${project.projTarget} --%></td>
						<td></td>
					</tr>
					<tr>
						<th>언어</th>
						<td><%-- ${project.projLang} --%></td>
						<th>DBMS</th>
						<td><%-- ${project.dbNum} --%></td>
						<th>TOOL/<br>FRAMEWORK</th>
						<td></td>
						<td></td>
					</tr>
				</td>
			<tr>
				<td align="right" colspan="7"><input type="button" value="자세히보기"></td>
			</tr>
		</table>
	</div>
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
			<c:forEach var="project" items="projectList">
				<tr>
					<%-- <td>${project.projState}</td>
					<td><a href="#">${project.projName}</a></td>
					<td>${project.projDevelopSort}</td>
					<td>${project.projStartDate}</td>
					<td>${project.projExpectedTime}</td>
					<td>${project.projRecruitEndDate }</td>
					<td></td> --%>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="/frame/footer.jsp" />
</body>
</html>