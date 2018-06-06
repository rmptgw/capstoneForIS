function freeState(freeState){

	switch(freeState){
	case sucess:
		document.getElement("freeState").value="1";
		break;
	case hold:
		document.getElement("freeState").value="2";
		break;
	case fail:
		document.getElement("freeState").value="3";
		break;
	}
}

function sendInterviewMsg(){
	// 면접일 지정을 위한 메시지창을 팝업창으로 띄워주는 메소드
	
	// checks 변수를 선언한 후 부모화면에서 이름이 checks인 체크박스의 value를 받아온다.
	var checks = document.getElementsByName('checks');
	
	var chk = "";
	
	for(i=0; i<checks.length; i++){
		// checks가 체크가 되었는지 확인한다.
		if(checks[i].checked === true){
			
			// 체크가 되었으면 chk에 해당 checks의 value를 '/'로 구분하여 저장한다.
			chk += checks[i].value + "/";
		}
	}
	
	if(chk == ""){
		// 선택된 체크박스가 없으면 실행이 선택된 프리랜서가 없다고 알림창이 뜬다.
		alert("면접을 볼 프리랜서를 선택해 주세요");
		return false;
	}
	/*
	alert(chk);
	*/
	
	// 펼쳐질 팝업창의 주소
	var url = "Eu?e=appointment_interview_form&chk=" + chk;
	
	// 팝업창을 펼친다.
	window.open(url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=600, height=300");
	
}

function sendAppointmentMsg(){
	/*체크해야 할 것들
	date(면접일), time(면접시간), location(면접 장소), content(면접관련 알림말)*/
	if(document.frm.date.value == null || document.frm.date.value==""){
		alert("면접일을 지정해주세요");
		return false;
	}
	if(document.frm.time.value == null || document.frm.time.value == ""){
		alert("면접 시간을 지정해주세요");
		return false;
	}
	if(document.frm.location.value == null || document.frm.location.value == ""){
		alert("면접 장소를 적어주세요");
		return false;
	}
	
	var inputs = document.getElementsByName('joinNum');
	var location = document.frm.location.value;
	var time = document.frm.time.value;
	var date = document.frm.date.value;
	var content = document.frm.content.value;
	
	var no = "";
	
	for(i = 0; i < inputs.length; i++){
		no += inputs[i].value + "/";
	}
	
	alert("참여번호 : " +  no + "\n location : " + location + "\n time : " + time 
			+ "\n date : " + date + "\n content : " + content);
	
	var url = "Eu?e=appointment_interview&no=" + no + "&location=" + location + 
	"&interviewDate=" + date + "&interviewTime=" + time + "&content=" + content;
	
	window.opener.location.href = url;
	
	self.close();
}

function sendResultMsg(){
	if(document.resultInterviewFrm.freeState == null || 
			document.resultInterviewFrm.freeState == ""){
		alert("채용 여부는 반드시 입력해야 하는 항목입니다.");
		resultInterviewFrm.choice.focus();
		return false;
	}
	if(document.resultInterviewFrm.interviewReason == null || 
			document.resultInterviewFrm.interviewReason == ""){
		alert("사유는 반드시 입력해야 하는 항목입니다.");
		resultInterviewFrm.choice.focus();
		return false;
	}
}