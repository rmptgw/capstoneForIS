<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>프리랜서 등록</title>
</head>
<body>
	<div>
		<form name="frm" action="Eu?c=free_form" method="post">
		<div>
			<table align="center" border="1">
				<tr>
					<td colspan="5"><h3>기본정보</h3></td>
				</tr>
				<tr>
					<td rowspan="8"><input type="image"><br> <input
						type="button" value="파일첨부"></td>
					<th>아이디</th>
					<td colspan="3"><input type="text" readonly="readonly"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" id="pw1"></td>
					<th>비밀번호 확인</th>
					<td><input type="text" id="pw2"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text"></td>
					<th>생년월일</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td><input type="radio" name="sex" value="male">남성 <input
						type="radio" name="sex" value="female">여성</td>
					<th>결혼여부</th>
					<td><input type="radio" name="married" value="yes">기혼
						<input type="radio" name="married" value="no">미혼</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text"></td>
					<th>이메일</th>
					<td><input type="text" placeholder="이메일을 입력해주세요"></td>
				</tr>
				<tr>
					<th rowspan="3">주소</th>
					<td colspan="3"><input type="text"> <input
						type="button" value="우편번호 찾기">
				</tr>
				<tr>
					<td colspan="3"><input type="text" id="freeFrontAddr"><br>
					</td>
				</tr>
				<tr>
					<td colspan="3"><input type="text" id="freeRearAddr"
						placeholder="상세한 주소를 입력해주세요"></td>
				</tr>
				<tr>
					<td colspan="5" align="right"><input type="button" value="수정">
						<input type="button" value="탈퇴"></td>
				</tr>
			</table>
		</div>
		<div>
			<table align="center" border="1">
				<tr>
					<td colspan="4"><h3>계좌 등록</h3></td>
				</tr>
				<tr>
					<th>은행</th>
					<td>
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
					</td>
					<th>계좌 명의</th>
					<td><input type="text"></td>
				</tr>
				<tr>
					<th>계좌번호</th>
					<td colspan="3">
						<input type="text">
					</td>
				</tr>
				<tr>
					<td colspan="4" align="right">
						<input type="button" value="등록">
					</td>
				</tr>
			</table>
		</div>
		<div>
			<jsp:include page="/common/info/education.jsp" />
		</div>
		<div>
			<jsp:include page="/common/info/career.jsp" />
		</div>
		<div>
			<jsp:include page="/common/info/skillInventory.jsp" />
		</div>
		</form>
	</div>
</body>
</html>