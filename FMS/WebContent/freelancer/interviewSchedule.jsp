<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<form action="Eu?c=appointment_interview_form" name="schduleFrm" method="post">
		<table>
			<tr>
				<th colspan="7">신청 접수한 프리랜서</th>
				<th>정렬기준</th>
				<th>
					<select>
						<option>종합</option>
						<option>평점순</option>
						<option>언어순</option>
						<option>경력순</option>
						<option selected="selected">학력순</option>
						<option>등급순</option>
						<option>최신순</option>
						<option>대기자</option>
						<option>참여신청자</option>
					</select>
				</th>
			</tr>
			<tr>
				<th>상태</th>
				<th>이름</th>
				<th>주언어</th>
				<th>가용 TOOL / framework </th>
				<th>경력</th>
				<th>프로젝트 참여횟수</th>
				<th>KOSA등급</th>
				<th>평점</th>
				<th>선택</th>
			</tr>
			<!-- 조인을 이용하여 보여주기 경력, 프리랜서, 언어, 툴/프레임워크 -->
			<c:forEach var="joinProj" items="${joinProjList}">
				<tr>
					<td>${joinProj.freeState}</td>
					<td>${joinProj.freeName}</td>
					<td>${joinProj.lang}</td>
					<td>${joinProj.FWskill} 전부 쓰기 </td>
					<td>${joinProj.career}</td>
					<td>프로젝트 참여횟수</td>
					<td>코사등급</td>
					<td>평점</td>
					<td><input type="checkbox"></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="면접일 지정"></td>
			</tr>
		</table>
	</form>
</div>
<div>
	<form action="Eu?c=result_interview" method="post" name="resultFrm">
		<table>
			<tr>
				<th colspan="4">면접 결과 등록</th>
				<th>
					정렬기준
					<select>
						<option>상태순</option>
						<option>날짜순</option>
					</select>	
				</th>
			</tr>
			<tr>
				<th>상태</th>
				<th>이름</th>
				<th>면접일</th>
				<th>장소</th>
				<th>채용여부</th>
				<th>사유</th>
			</tr>
			<c:forEach var="interview" items="interviewList">
				<tr>
					<td>${interview.intvState}</td>
					<td>${interview.freeId}</td>
					<td>${interview.intvDate}</td>
					<td>${interview.intvLocation}</td>
					<td>
						<input type="radio" name="choice" id="sucess">채용
						<input type="radio" name="choice" id="hold">보류
						<input type="radio" name="choice" id="fail">불채용
					</td>
					<td><input type="text" name="intvReason"></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
					<input type="submit" value="결과등록">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>