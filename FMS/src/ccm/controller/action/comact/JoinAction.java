package ccm.controller.action.comact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ccm.controller.action.Action;
import ccm.dao.FreelancerDAO;
import ccm.data.table.Freelancer;

public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fID = request.getParameter("fid");
		String fPW = request.getParameter("fpw");
		String fl_faddr = request.getParameter("fid_front");
		String fl_raddr = request.getParameter("fid_rear");
		String fl_email = fl_faddr + "@" +fl_raddr;
		
		Freelancer fVo = new Freelancer();
		
		fVo.setFreeId(fID);
		fVo.setFreePw(fPW);
		fVo.setFreeEmail(fl_email);

		FreelancerDAO fDao = FreelancerDAO.getInstance();
		
		int result = fDao.insertFL(fVo);
		
		HttpSession session = request.getSession();
		
		if (result == 1) {
			session.setAttribute("fID", fVo.getFreeId());
			request.setAttribute("message", "회원 가입에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원 가입에 실패했습니다.");
		}
		
		String url = "Eu?c=main";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}