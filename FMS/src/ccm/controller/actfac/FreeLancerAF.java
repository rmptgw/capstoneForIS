package ccm.controller.actfac;

import ccm.controller.action.Action;

public class FreeLancerAF
{
	private static FreeLancerAF instance = new FreeLancerAF();
	
	private FreeLancerAF() {
		// TODO Auto-generated constructor stub
		super(); 
	 }
	public static FreeLancerAF getInstance() { return instance; }
	
	public Action getAction(String command) 
	{
		Action action = null;
		System.out.println("FreelancerAF :" + command);
		
		return action;
	}
}
