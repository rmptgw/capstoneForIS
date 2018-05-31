package ccm.controller.action.comact;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.action.Action;
import ccm.dao.CommonDAO;
import ccm.data.table.Project;

public class GoToMainAction implements Action
{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		CommonDAO cDao = CommonDAO.getInstance();
		/*Project project = cDao.selectLastJoinProject();
		List<Project> projectList = cDao.selectAllJoinProject();
		
		request.setAttribute("projectList", projectList);
		request.setAttribute("project", project);*/
		
		request.getRequestDispatcher("common/main.jsp").forward(request, response);
	}
}
