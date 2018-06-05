package ccm.controller.action.empact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.action.Action;
import ccm.dao.EmployeeDAO;
import ccm.data.table.JoinProj;

public class AppointmentInterviewFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/employee/sendInterviewMsg.jsp";
		String[] joinNum = request.getParameterValues("no");
		for(int i=0;i<joinNum.length;i++) {
			System.out.println("받은 JoinNum : " + joinNum[i]);
		}
		
		List<JoinProj> join = new ArrayList<JoinProj>();
		EmployeeDAO eDao = EmployeeDAO.getInstance();

		// 
		for(int i=0; i<joinNum.length; i++) {
			join.add(eDao.getJoinProjByNo(joinNum[i]));
			System.out.println("join 프로젝트 : " + join);
			eDao.updateInterviewStateByJoinNum(joinNum[i]);
		}
		
		request.setAttribute("joinFreeList", join);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
