package ccm.controller.action.empact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.action.Action;
import ccm.dao.CommonDAO;
import ccm.dao.EmployeeDAO;
import ccm.data.table.Employee;
import ccm.data.table.JoinFreelancerInterview_view;
import ccm.data.table.JoinProj;
import ccm.data.table.Message;

public class AppointmentInterviewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "Eu?e=interview_schedule";
		
		// 폼을 통해 보내온 데이터를 각 객체에 넣는다.
		String no = request.getParameter("no");
		String[] joinNum = no.split("/");
		String content = request.getParameter("content");
		String interviewDate = request.getParameter("interviewDate");
		String interviewTime = request.getParameter("interviewTime");
		String location = request.getParameter("location");
		String date = interviewDate + " " + interviewTime;
		
		
		for(int i=0; i<joinNum.length; i++) {
			System.out.println("참여번호 : " + joinNum);
		}
		System.out.println("내용 : " + content);
		System.out.println("일시 : " + date);
		System.out.println("장소 : " + location);
		
		CommonDAO cDao = CommonDAO.getInstance();
		EmployeeDAO eDao = EmployeeDAO.getInstance();
		
		
		JoinProj joinProj = null;
		
		// 세션을 통해 관리자(사원)의 정보를 가져온다.
		Employee empTempVo = (Employee) request.getSession().getAttribute("loginemp");
		
		for(int i=0; i<joinNum.length; i++) {
			System.out.println("보내온 joinNum : " + joinNum[i]);
			
			JoinFreelancerInterview_view free = eDao.getJoinFreeInterviewByNo(joinNum[i]);
			Message msg = new Message();
			
			// 작성자, 제목, 내용을 메시지 객체에 지정한다.
			msg.setEmpWriter(empTempVo.getEmpId());
			msg.setMsgTitle("면접일정 안내 메시지 입니다.");
			msg.setMsgContent( free.getFreeName() + "님 " + interviewDate + "일 " + interviewTime + "에" + " " 
							+ location + "에서 면접이 있습니다." + " " + content);
			
			
			System.out.println("발신자 : " + msg.getEmpWriter());
			System.out.println("제목 : " + msg.getMsgTitle());
			System.out.println("내용 : " + msg.getMsgContent());
			
			// 받아온 참여번호를 통해 인터뷰 상태 날짜, 시간, 장소 등을 업데이트 한다.
			eDao.updateInterviewStateByJoinNum(joinNum[i], location, date);
			
			// 참여 번호를 통해 참여 정보를 가져온다을 지정한다.
			joinProj = eDao.getJoinProjByNo(joinNum[i]);
			
			System.out.println("보내지는 면접일정 메시지 : " + msg);
			System.out.println("가져온 참여 정보 : " + joinProj);
			

			// 참여 번호를 통해 참여상태를 바꾸어준다.
			eDao.updateFreeStateByJoinNum(joinNum[i], "접수완료");
			
			// 결정된 면접 일정을 받는이에게 보낸다.
			cDao.sendInterviewMsg(msg, joinProj.getJoinNum());
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
