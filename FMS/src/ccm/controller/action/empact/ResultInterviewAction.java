package ccm.controller.action.empact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.action.Action;
import ccm.dao.EmployeeDAO;

public class ResultInterviewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "employee/interviewSchedule.jsp";
		
		// 각 이름으로 받아오는 파라메터 값을 String형 배열에 적용한다.
		String interviewReason = new String(request.getParameter("interviewReason").getBytes("8859_1"),"UTF-8");
		String joinNum = request.getParameter("joinNum");
		String freeState = request.getParameter("freeState");
		String interviewNum = request.getParameter("no");
		
		System.out.println("interviewReason : " + interviewReason);
		System.out.println("interviewNum : " + interviewNum);
		System.out.println("joinNum : " + joinNum);
		System.out.println("freeState : " + freeState);
		
		String[] state = freeState.split("/");
		String[] joinNo = joinNum.split("/");
		String[] reason = interviewReason.split("/");
		String[] no = interviewNum.split("/");
		
		
		EmployeeDAO eDao = EmployeeDAO.getInstance();
		
		for(int i=0; i<joinNo.length; i++) {
			System.out.println("state" + i + " : " + state);
			System.out.println("reason" + i + " : " + reason);
			System.out.println("interviweNum" + i + " : " + no);
			System.out.println("joinNum" + i + " : " + joinNo);
		}
		
		
		for(int i=0; i < joinNo.length; i++) {
			if(state[i] == null || state[i] == "") {
				continue;
			}
			if(reason[i] == null || reason[i] == "") {
				continue;
			}
			
			eDao.updateInterviewReasonByinterviewNo(no[i], reason[i]);
			
			switch(state[i]) {
			case "sucess":
				eDao.updateFreeStateByJoinNum(joinNo[i], "참여중");
				break;
			case "hold":
				eDao.updateFreeStateByJoinNum(joinNo[i], "보류");
				break;
			case "fail":
				eDao.updateFreeStateByJoinNum(joinNo[i], "불채용");
				break;
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
