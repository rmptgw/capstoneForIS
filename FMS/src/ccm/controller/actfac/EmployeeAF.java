package ccm.controller.actfac;

import ccm.controller.action.Action;
import ccm.controller.action.empact.*;

public class EmployeeAF
{
	private static EmployeeAF instance = new EmployeeAF();
	private EmployeeAF() {
		// TODO Auto-generated constructor stub
	 super(); }
	
	public static EmployeeAF getInstance() { return instance; }
	
	public Action getAction(String command) 
	{
		Action action = null;
		System.out.println("EmployeeAF :" + command);

		if (command.equals("emp_main")) { 
			action = new EmployeeMainAction();
		} else if (command.equals("emp_view")) {
			action = new EmployeeViewAction();
		}
		
		return action;
	}
}
