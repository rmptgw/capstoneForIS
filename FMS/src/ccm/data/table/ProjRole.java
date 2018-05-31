package ccm.data.table;

public class ProjRole
{
	/*
	
	RNUM BIGINT NOT NULL AUTO_INCREMENT, #역할 번호
  RNAME VARCHAR(12) NOT NULL, #역할 이름
  REQNUM INT NOT NULL, #필요 인원
  PNUM BIGINT NULL, #프로젝트 번호
	
	*/
	
	private int rNum;
	private String rName;
	private int reqNum;
	private int pNum;
	
	public ProjRole() { super(); }
	public ProjRole(int rNum, String rName, int reqNum, int pNum)
	{
		super();
		this.rNum = rNum;
		this.rName = rName;
		this.reqNum = reqNum;
		this.pNum = pNum;
	}


	public int getrNum() { return rNum; }
	public void setrNum(int rNum) { this.rNum = rNum; }
	public String getrName() { return rName; }
	public void setrName(String rName) { this.rName = rName; }
	public int getReqNum() { return reqNum; }
	public void setReqNum(int reqNum) { this.reqNum = reqNum; }
	public int getpNum() { return pNum; }
	public void setpNum(int pNum) { this.pNum = pNum; }
}
