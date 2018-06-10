package ccm.controller.actfac;

import ccm.controller.action.Action;
import ccm.controller.action.empact.*;

public class EmployeeAF
{
	private static EmployeeAF instance = new EmployeeAF();
	private EmployeeAF() {
		// TODO Auto-generated constructor stub
	 super(); }
	
	public static EmployeeAF getInstance() { return instance; }
	
	public Action getAction(String command) 
	{
		Action action = null;
		System.out.println("EmployeeAF :" + command);

		if (command.equals("emp_main")) { 
			// 사원의 메인페이지로 이동하는 액션
			action = new EmployeeMainAction();
		} else if (command.equals("emp_view")) {
			// 사원정보 상세보기 페이지로 이동하는 액션
			action = new EmployeeViewAction();
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
			action = new sendInputMessageAction();
		} else if (command.equals("send_input_message_form")) {
			// 투입메시지를 전송하는 액션
			action = new SendInputMessageFormAction();
		} 
		
		return action;
	}
}
