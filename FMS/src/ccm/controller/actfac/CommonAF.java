package ccm.controller.actfac;

import ccm.controller.action.*;
import ccm.controller.action.comact.*;
import ccm.controller.action.empact.AppointmentInterviewAction;
import ccm.controller.action.empact.AppointmentInterviewFormAction;
import ccm.controller.action.empact.InterviewScheduleAction;
import ccm.controller.action.empact.ResultInterviewAction;

/***************************
 * 
 * 
 * �븙�� �씤�꽣�럹�씠�뒪
 * �씠嫄몃줈 媛� 湲곕뒫�쓽 �븸�뀡�쓣 留뚮뱺�떎
 * 
 * �옉�꽦�옄 : 
 * 
 * �닔�젙�옄 : 
 * 
 * �닔�젙�씪 : 
 *
 *
 ***************************/

public class CommonAF
{
	private static CommonAF instance = new CommonAF();
	private CommonAF() { super(); }
	
	public static CommonAF getInstance() { return instance; }
	
	public Action getAction(String command) 
	{
		Action action = null;
		System.out.println("CommonAF :" + command);

		if (command.equals("main")) { 
			// 메인페이지로 이동하는 액션
			action = new GoToMainAction(); 
		} else if (command.equals("login")) {
			// 로그인을 하기 위해 정보가 맞는지 확인하는 액션
			action = new GoToLoginAction();
		} else if(command.equals("login_form")) {
			// 로그인을 하기 위한 페이지로 이동하는 액션
			action = new LoginProcessAction();
		} else if (command.equals("logout")){
			// 로그아웃을 하기 위한 액션
			action = new LogoutProcessAction();
		} else if (command.equals("join_form")) {
			// 회원가입을 위한 페이지로 이동하는 액션
			action = new JoinFormAction();
		} else if (command.equals("join")) {
			// 회원가입시 입력한 정보를 DB에 넣어주는 엑션
			action = new JoinAction();
		} else if (command.equals("message")) {
			// 메시지를 보내는 액션
			action = new MessageAction();
		}	else if (command.equals("receive_message")) {
			// 메시지를 보내는 액션
			action = new ReceiveMessageAction();
		} else if (command.equals("show_message")) {
			// 메세지를 확인하는 액션
			action = new ShowMessageAction();
		} else if (command.equals("msg_select_project")) {
			// 메세지와 연관된 프로젝트 번호를 프로젝트에 넣어주는 액션
			action = new SelectProjectAction();
		} else if (command.equals("msg_select_receiver")) {
			// 메세지와 연관된 수신인을 찾는 액션
			action = new SelectReceiverAction();
		} else if (command.equals("interview")) {
			// 면접 일정 / 결과등록 페이지로 이동하는 액션
			action = new InterviewScheduleAction();
		} else if (command.equals("result_interview")) {
			// 면접 결과를 등록하는 액션
			action = new ResultInterviewAction();
		} else if (command.equals("appointment_interview")) {
			// 면접일 지정한 후 지정된 면접일과 기타 정보들을 전달해주는 액션
			action = new AppointmentInterviewAction();
		} else if (command.equals("appointment_interview_form")) {
			// 면접일을 지정하기 위한 페이지로 이동하는 액션
			action = new AppointmentInterviewFormAction();
		} else if (command.equals("interview_schedule")) {
			// 면접일정을 확인하고 결과를 등록하기 위한 페이지로 이동하는 액션
			action = new InterviewScheduleAction();
		} else if (command.equals("send_input_message")) {
			// 투입메시지를 전송하는 액션
			action = new SendInputMessage();
		}

		return action;
	}
}
