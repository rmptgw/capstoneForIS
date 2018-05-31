<%-- 

	로그인하면 왼쪽에 뜨는 미니프로필이다
	
	작성자 : 

	수정일 : 
	
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:choose>
	<c:when test="${loginemp == null}">
		<%-- 직원이 null이니까 프리랜서 프로필 출력하면됨 --%>
		<table>
			<tr>
				<td colspan="2"><img src="${loginfree.pic}"></td>
			</tr>
			<tr>
				<td colspan="2">${loginfree.name}</td>
			</tr>
			<tr>
				<td colspan="2">${loginfree.phone}</td>
			</tr>
			<tr>
				<td>참여신청<br>${알아서해}</td>
				<td>진행프로젝트<br>${알아서해}</td>
			</tr>
			<tr>
				<td>신규메시지<br>${loginfree.name}</td>
				<td></td>
			</tr>
			<tr>
				<td><a href="">프리랜서 등록/수정</a></td>
			</tr>
			<tr>
				<td><a href="">프리랜서 찾기</a></td>
			</tr>
			<tr>
				<td><a href="">면접 일정/결과</a></td>
			</tr>
			<tr>
				<td><a href="">메시지 확인</a></td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<%-- otherwise니까 당연히 직원프로필을 출력해야겠지 --%>
		<%-- 여기도 비슷하게 만들면됨 --%>
		
	</c:otherwise>
</c:choose>