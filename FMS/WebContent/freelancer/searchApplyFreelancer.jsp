<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>참여신청자 목록</title>
</head>
<body>
	<div>
		<table align="center" border="1">
			<tr>
				<th colspan="7"><h3>프리랜서 목록</h3></th>
				<th>정렬기준</th>
				<th>
					<select>
						<option>최신순</option>
						<option>신청일 마감순</option>
						<option>참여자</option>
						<option>접수자</option>

						<option selected="selected">참여신청자</option>
					</select>
				</th>
			</tr>
			<tr>
				<c:forEach var="free" items="${serchApplyFreelancer}">
					<tr class="record">
						<a href="Eu?c=freelancerView&fID">
							<th>이름</th>
							<td>${free.freename}</td>
							<th>아이디</th>
							<td>${free.fid}</td>
							<th>이메일</th>
							<td>${free.email}</td>
							<td>${free.phone}</td>
						</a>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</div>
</body>
</html>