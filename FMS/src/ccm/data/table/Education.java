package ccm.data.table;

import java.util.Date;

public class Education
{
	/*
	ENUM BIGINT NOT NULL AUTO_INCREMENT, #학력번호
  SCHOOL VARCHAR(15) NOT NULL, #학교명
  DEPLOMA VARCHAR(2) NULL, #학위
  MAJOR VARCHAR(15) NOT NULL, #전공
  JOINDATE DATE NOT NULL DEFAULT NOW(), #입학일
  GRADDATE DATE NULL, #졸업일(예정일)
  FID VARCHAR(15) NULL, #프리랜서아이디
  EID VARCHAR(15) NULL, #직원아이디
	*/
	
	private int eNum;
	private String school;
	private String deploma;
	private String major;
	private Date joinDate;
	private Date gradDate;
	private String fId;
	private String eId;
	
	public Education() { super(); }
	public Education(int eNum, String school, String deploma, String major, Date joinDate, Date gradDate, String fId,
			String eId)
	{
		super();
		this.eNum = eNum;
		this.school = school;
		this.deploma = deploma;
		this.major = major;
		this.joinDate = joinDate;
		this.gradDate = gradDate;
		this.fId = fId;
		this.eId = eId;
	}
	
	public int geteNum() { return eNum; }
	public void seteNum(int eNum) { this.eNum = eNum; }
	public String getSchool() { return school; }
	public void setSchool(String school) { this.school = school; }
	public String getDeploma() { return deploma; }
	public void setDeploma(String deploma) { this.deploma = deploma; }
	public String getMajor() { return major; }
	public void setMajor(String major) { this.major = major; }
	public Date getJoinDate() { return joinDate; }
	public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
	public Date getGradDate() { return gradDate; }
	public void setGradDate(Date gradDate) { this.gradDate = gradDate; }
	public String getfId() { return fId; }
	public void setfId(String fId) { this.fId = fId; }
	public String geteId() { return eId; }
	public void seteId(String eId) { this.eId = eId; }
}
