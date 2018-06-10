package ccm.controller.action.comact;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.action.Action;
import ccm.dao.CommonDAO;
import ccm.data.table.Project_Info_view;

public class GoToMainAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		CommonDAO cDao = CommonDAO.getInstance();
		Project_Info_view project_Info_view = cDao.selectLastRegistProject();
		List<Project_Info_view> projectList = cDao.selectAllJoinableProject();
		
		request.setAttribute("projectList", projectList);
		request.setAttribute("project", project_Info_view);
		
		request.getRequestDispatcher("common/main.jsp").forward(request, response);
	}
}
