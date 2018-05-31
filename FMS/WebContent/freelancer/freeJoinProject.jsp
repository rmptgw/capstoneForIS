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
		<form>
			<table align="center" border="1">
				<tr>
					<th colspan="3"><h3>참여 신청한 프리랜서</h3></th>
					<td><input type="text" id="findFreelancer"></td>
					<td><input type="button" value="검색" onclick=""></td>
					<th>정렬기준</th>
					<th><select>
							<option>최신순</option>
							<option>신청일 마감순</option>
							<option>참여자</option>
							<option>접수자</option>
							<option selected="selected">참여신청자</option>
					</select></th>
				</tr>
				<tr>
					<th>상태</th>
					<th>이름</th>
					<th>아이디</th>
					<th>참여신청자 프로잭트명</th>
					<th>신청일</th>
					<th>모집마감일</th>
					<th>선택</th>
				</tr>
				<c:forEach var="join" items="${joinProject}">
					<tr class="record">
						<td>${join.fsate}</td>
						<td>${join. }</td>
						<td>${join.fid}</td>
						<td>${join.}</td>
						<td>${join.appdate}</td>
						<td>${join. }마감일</td>
						<td><input type="checkbox" name="" value=""></td>
					</tr>
				</c:forEach>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>