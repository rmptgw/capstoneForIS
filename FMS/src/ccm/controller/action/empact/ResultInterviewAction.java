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
		String[] interviewReason = request.getParameterValues("interviewReason");
		String[] joinNum = request.getParameterValues("joinNum");
		String[] freeId = request.getParameterValues("free[]");
		String[] choice = request.getParameterValues("choice[]");
		
		EmployeeDAO eDao = EmployeeDAO.getInstance();
		
		for(int i=1; i < joinNum.length; i++) {
			eDao.updateInterviewReasonByfreeId(freeId[i], interviewReason[i]);
			
			switch(choice[i]) {
			case "sucess":
				eDao.updateFreeStateByJoinNum(joinNum[i], "참여중");
				break;
			case "hold":
				eDao.updateFreeStateByJoinNum(joinNum[i], "보류");
				break;
			case "fail":
				eDao.updateFreeStateByJoinNum(joinNum[i], "불채용");
				break;
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
