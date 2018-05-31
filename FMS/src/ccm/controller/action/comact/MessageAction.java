package ccm.controller.action.comact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.action.Action;
import ccm.dao.CommonDAO;
import ccm.dao.EmployeeDAO;
import ccm.dao.FreelancerDAO;
import ccm.data.table.Employee;
import ccm.data.table.Freelancer;
import ccm.data.table.Message;

public class MessageAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "common/msg/showMsg.jsp";
		
		String prevMsgNum = request.getParameter("prevMsgNum");
		String freeWriter = request.getParameter("freeWriter");
		String empWriter = request.getParameter("empWriter");
		String freeReceiver = request.getParameter("freeReceiver");
		String empReceiver = request.getParameter("empReceiver");
		String projNum = request.getParameter("projNum");
		String title = request.getParameter("msgTitle");
		String content = request.getParameter("msgContent");
		
		
		System.out.println("프리랜서 수신인" + freeReceiver);
		System.out.println("사원 수신인" + empReceiver);
		
		Message msgVo = new Message();
		
		CommonDAO cDao = CommonDAO.getInstance();
		FreelancerDAO fDao = FreelancerDAO.getInstance();
		EmployeeDAO eDao = EmployeeDAO.getInstance();
		
		Freelancer free = fDao.getfVo(freeReceiver);
		Employee emp = eDao.geteVo(empReceiver);
		
		System.out.println("프리랜서 수신인 : " + free);
		System.out.println("사원 수신인 : " + emp);
		
		if(freeReceiver != null) {
			msgVo.setFreeReceiver(freeReceiver);
			System.out.println(freeReceiver);
		} 
		if (empReceiver != null) {
			msgVo.setEmpReceiver(empReceiver);
			System.out.println(empReceiver);
		}

		// 각각의 값을 지정함
		msgVo.setPrevMsgNum(prevMsgNum);
		msgVo.setFreeWriter(freeWriter);
		msgVo.setEmpWriter(empWriter);
		msgVo.setMsgTitle(title);
		msgVo.setMsgContent(content);
		msgVo.setProjNum(projNum);
		
		System.out.println(msgVo);
		
		// DB에 삽입함/ 메시지를 보냄
		cDao.insertMsg(msgVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
