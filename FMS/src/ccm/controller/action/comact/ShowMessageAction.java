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

public class ShowMessageAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// showMsg/메시지 확인 페이지로 이동하는 액션
		String url = "common/msg/showMsg.jsp";
		
		// 보내진 no를 msgNo 변수에 적용한다.
		String msgNo = request.getParameter("no");
		String checked = request.getParameter("check");
		
		System.out.println(checked);
		
		// 메세지 객체 생성
		Message message = null;
		
		CommonDAO cDao = CommonDAO.getInstance();
		FreelancerDAO fDao = FreelancerDAO.getInstance();
		EmployeeDAO eDao = EmployeeDAO.getInstance();
		
		// 메시지 번호를 통해 수신일을 업데이트 한다.
		if(checked != "1") {		
	 	// 만약 msgChecked가 1이 아니면 메세지 번호를 통해 수신일을 업데이트하고 msgChecked를 1로 바꾼다.
			message = cDao.updateMsgCheckedDate(msgNo);
		}
		
		// 메시지 번호를 통해 해당 메시지를 가져온다.
		message =  cDao.selectOneMsgByNo(msgNo);
		System.out.println("가져온 메시지 : " + message);
		// 현재 사용자의 회원번호를 세션으로부터 가져오는 과정
		Freelancer freeTempVo = (Freelancer) request.getSession().getAttribute("loginfree");
		Employee empTempVo = (Employee) request.getSession().getAttribute("loginemp");
				
		
		System.out.println("세션값 free" + freeTempVo);
		System.out.println("*******************");
		System.out.println("세션값 emp" + empTempVo);
		
		// 메시지 리스트를 생성한다
		List<Message> messageList = null;
		
		if( freeTempVo != null ) {
			// 세션을 통해 가져온 사용자의 아이디가 프리랜서일 때 해당 프리랜서가 받은 메시지 목록을 받아온다.
			messageList = cDao.selectAllMsgFree(freeTempVo.getFreeId());
			
		} else if( empTempVo != null ) {
			// 세션을 통해 가져온 사용자의 아이디가 사원일 때 해당 사원이 받은 메시지 목록을 받아온다.
			messageList = cDao.selectAllMsgEmp(empTempVo.getEmpId());
		}

		System.out.println(message);
		// 메시지의 작성자 아이디를 통해 작성자의 정보를 가져온다.
		if(empTempVo != null && msgNo != null) {
			Freelancer free = fDao.getfVo(message.getFreeWriter());
			System.out.println(free);
			request.setAttribute("free", free);
		} else if (freeTempVo != null && msgNo != null) {
			Employee emp = eDao.geteVo(message.getEmpWriter());
			System.out.println(emp);
			request.setAttribute("emp", emp);
		}
		
		// 각 객체를 ""안의 이름으로 전달한다.
		request.setAttribute("messageList", messageList);
		request.setAttribute("message", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
