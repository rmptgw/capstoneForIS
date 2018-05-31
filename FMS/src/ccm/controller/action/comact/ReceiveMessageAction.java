package ccm.controller.action.comact;

import java.io.IOException;
import java.util.List;

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

public class ReceiveMessageAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "common/msg/showMsg.jsp";
		// 보내진 no를 msgNo 변수에 적용한다.
		String msgNo = request.getParameter("no");
		
		// 보내진 작성자를 수신인으로 저장
		String freeReceiver = request.getParameter("freeWriter");
		String empReceiver = request.getParameter("empWriter");
		
		System.out.println("메시지 번호 : " + msgNo);
		System.out.println("보낸이(프리랜서 아이디) : " + freeReceiver);
		System.out.println("보낸인(사원 아이디) : " + empReceiver);
		
		CommonDAO cDao = CommonDAO.getInstance();
		FreelancerDAO fDao = FreelancerDAO.getInstance();
		EmployeeDAO eDao = EmployeeDAO.getInstance();
		
		//수신인 정보를 가져옴
		Freelancer free = fDao.getfVo(freeReceiver);
		Employee emp = eDao.geteVo(empReceiver);
		
		Message reMsg = new Message();
		
		// 현재 사용자의 회원번호를 세션으로부터 가져오는 과정
		Freelancer freeTempVo = (Freelancer) request.getSession().getAttribute("loginfree");
		Employee empTempVo = (Employee) request.getSession().getAttribute("loginemp");
						
		System.out.println(freeTempVo);
		System.out.println(empTempVo);
				
		List<Message> messageList = null;
				
		if( freeTempVo != null ) {
			messageList = cDao.selectAllMsgFree(freeTempVo.getFreeId());
			request.setAttribute("freeTemp", freeTempVo);
		} else if( empTempVo != null ) {
			messageList = cDao.selectAllMsgEmp(empTempVo.getEmpId());
			request.setAttribute("empTemp", empTempVo);
		}
		
		reMsg.setPrevMsgNum(msgNo);
		reMsg.setProjNum(request.getParameter("projNum"));
		reMsg.setMsgTitle("Re:" + request.getParameter("msgTitle"));
		
		if( freeReceiver!= null ) {
			reMsg.setFreeReceiver(free.getFreeName());
			System.out.println(reMsg);
		} 
		if( empReceiver != null ) {
			reMsg.setEmpReceiver(emp.getEmpId());
			System.out.println(reMsg);
		}

		System.out.println("------------------");
		System.out.println(reMsg);
		System.out.println("------------------");
		
		
		request.setAttribute("reFree", free);
		request.setAttribute("reEmp", emp);
		request.setAttribute("reMsg", reMsg);
		request.setAttribute("messageList", messageList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
