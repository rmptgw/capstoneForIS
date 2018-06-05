package ccm.controller.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ccm.controller.actfac.CommonAF;
import ccm.controller.actfac.EmployeeAF;
import ccm.controller.actfac.FreeLancerAF;
import ccm.controller.action.Action;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Eu")
public class CommonServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonServ()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		String command = null;	
		String common = request.getParameter("c");
		String free = request.getParameter("f");
		String emp = request.getParameter("e");

		Action action = null;
		
		if(common != null) {
			command = common; 
			System.out.println(command);
			CommonAF af = (CommonAF) CommonAF.getInstance();
			action = af.getAction(command);
			
		} else if (emp != null) {
			command = emp;
			System.out.println(command);
			EmployeeAF af = (EmployeeAF) EmployeeAF.getInstance();
			action = af.getAction(command);

		} else if (free != null) {
			command = free;
			System.out.println(command);
			FreeLancerAF af = (FreeLancerAF) FreeLancerAF.getInstance();
			action = af.getAction(command);
		}
		
		if(action != null)
		{
			action.execute(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		doGet(request, response);
	}

}
