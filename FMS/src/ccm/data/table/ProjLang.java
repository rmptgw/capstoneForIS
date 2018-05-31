package ccm.data.table;

public class ProjLang
{
	/*
		PNUM BIGINT NOT NULL, #프로젝트 번호
  LNUM BIGINT NOT NULL, #프로그래밍 언어 번호
	*/
	
	private int pNum;
	private int lNum;
	
	public ProjLang(int pNum, int lNum)
	{
		super();
		this.pNum = pNum;
		this.lNum = lNum;
	}
	
	public int getpNum() { return pNum; }
	public void setpNum(int pNum) { this.pNum = pNum; }
	public int getlNum() { return lNum; }
	public void setlNum(int lNum) { this.lNum = lNum; }
}
