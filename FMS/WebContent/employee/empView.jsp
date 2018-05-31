<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 계정 상세보기</title>
</head>
<body>
	<div>
		<h3>사원 계정 상세보기</h3>
		<form name="frm" method="post" action="emp_common_info_edit">
			<div>
				<table align="center" border="1">
					<tr>
						<td rowspan="10"align="center"><input
							type="image" src=""><br> <input type="button"
							value="파일 첨부"></td>
					</tr>
					<tr>
						<td align="center">아이디</td>
						<td>${emp.eid}</td>
						<td align="center">작성일</td>
						<td colspan="4"></td>
					</tr>
					<tr>
						<td align="center">이름</td>
						<td>${emp.ename}</td>
						<td align="center">부서</td>
						<td>
							<select>
								<option>SI사업팀</option>
								<option>SM사업팀</option>
								<option>총무/회계팀</option>
								<option>부설연구소</option>
							</select>
						</td>
						<td align="center">직책</td>
						<td>
							<select>
								<option>대표이사</option>
								<option>본부장</option>
								<option>이사</option>
								<option>PM</option>
								<option>PL</option>
								<option>사원</option>
							</select>
						</td>
					</tr>
					<tr>
						<td align="center">입사일</td>
						<td><label>${emp.joindate}</label></td>
						<td align="center">퇴사일</td>
						<td><label>${emp.dropdate}</label></td>
						<td align="center">등급</td>
						<td></td>
					</tr>
					<tr>
						<td align="center">생년월일</td>
						<td>${emp.birth}</td>
						<td align="center">성별</td>
						<td>
							<input type="radio" name="sex" value="male">남성
							<input type="radio" name="sex" value="female">여성
						</td>
						<td align="center">결혼여부</td>
						<td>
							<input type="radio" name="married" value="yes">기혼
							<input type="radio" name="married" value="no">미혼
						</td>
					</tr>
					<tr>
						<td align="center">전화번호</td>
						<td><input type="text"></td>
						<td align="center">이메일</td>
						<td colspan="4"><input type="text"></td>
					</tr>
					<tr>
						<td rowspan="3" align="center">주&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;소</td>
						<td colspan="6">
							<input type="text">
							<input type="button" value="우편번호 검색">
						</td>
					</tr>
					<tr>
						<td colspan="5"><input type="text"></td>
					</tr>
					<tr>
						<td colspan="5"><input type="text" placeholder="상세주소를 입력해주세요"></td>
					</tr>
					<tr>
						<td align="center">계&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;좌</td>
						<td colspan="5">
							<select>
								<option selected="selected"></option>
								<option>경남</option>
								<option>광주</option>
								<option>대구</option>
								<option>부산</option>
								<option>산업</option>
								<option>수협</option>
								<option>신한</option>
								<option>스텐다드차티드</option>
								<option>우리</option>
								<option>전북</option>
								<option>제주</option>
								<option>CITI</option>
								<option>IBK기업</option>
								<option>KB국민</option>
								<option>KEB하나</option>
								<option>NH농협</option>
							</select>
							<label>계좌번호</label>
							<input type="text" placeholder="번호만 입력해주세요">
						</td>
					</tr>
				</table>
			</div>
			<div>
				<jsp:include page="/common/info/education.jsp"/><!-- 학력 -->
			</div>
			<div>
				<jsp:include page="/common/info/career.jsp"/><!-- 경력 -->
			</div>
			<div>
				<jsp:include page="/common/info/skillInventory.jsp"/><!-- skillInventory -->
			</div>
			<div>
				<table align="center" border="1">
					<tr>
						<td></td>
						<td align="center">
							<input type="button" value="닫기">
						</td>
						<td colspan="3">
							<input type="button" value="전체등록"> 
							<input type="button" value="계정삭제" style="color: red;"> 
							<input type="button" value="▲TOP">
						</td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>