package ccm.controller.action.comact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.action.Action;
import ccm.dao.CommonDAO;
import ccm.data.table.ProjectInfo;

public class ShowProjectInfoAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "project/showProjectInfo.jsp";
		
		CommonDAO cDao = CommonDAO.getInstance();

		// 메인페이지에서 no로 보내온 프로젝트 번호를 문자열(String) no에 저장한다.
		String no = request.getParameter("no");
		
		
		// 프로젝트번호가 저장된 no을 사용하여 프로젝트 정보를 가져온다.
		ProjectInfo projectInfo = cDao.selectOneProjByNo(no);
		
		request.setAttribute("project", projectInfo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
