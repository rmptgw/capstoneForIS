function selectProject(){
	if(document.sendMsgFrm.receiver.value == null){
		alert("수신인을 입력한 후에 검색을 눌러주세요");
		sendMsgFrm.receiver.focus();
		return false;
	}
	var url = "Eu?c=msg_select_project&freeId="+document.sendMsgFrm.freeReceiver.value;
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function selectReceiver(){
	var url = "Eu?c=msg_select_receiver";
	window.open(url, "_blank_1",
					"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
}

function chooseReceiverFree(){
	opener.document.getElementById("receiver").value = document.getElementById("freeReceiver").value;
	opener.document.getElementById("freeReceiver").value = document.getElementById("freeReceiverId").value;
	
	opener.document.getElementById("freeReceiver").style.display = "";
	opener.document.getElementById("empReceiver").style.display = "none";
	
	self.close();
}

function chooseReceiverEmp(){
	opener.document.getElementById("empReceiver").value = document.getElementById("empReceiver").value;
	
	opener.document.getElementById("freeReceiver").style.display = "none";
	opener.document.getElementById("empReceiver").style.display = "";
	
	self.close();
}

function chooseProject(){
	opener.document.getElementById("projNum").value = document.getElementById("projNum").value;
	self.close();
}

function sendCheck(){
	if(document.sendMsgFrm.receiver.value=""){
		alert("수신인은 반드시 입력해야 합니다.");
		sendMsgFrm.receiver.focus();
		return false;
	}
	if(document.sendMsgFrm.title.value=""){
		alert("제목을 입력해 주세요.");
		sendMsgFrm.title.focus();
		return false;
	}
	if(document.sendMsgFrm.content.value=""){
		alert("내용을 입력해 주세요.");
		sendMsgFrm.content.focus();
		return false;
	}
}