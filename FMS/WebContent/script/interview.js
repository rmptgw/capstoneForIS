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
	if(document.schduleFrm.chk.checked == false){
		alert("선택된 프리랜서가 없습니다.");
		return false;
	}
	var url = "Eu?e=appointment_interview_form&no="+document.schduleFrm.chk.value;
	window.open(url, "_blank_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=600, height=300");
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