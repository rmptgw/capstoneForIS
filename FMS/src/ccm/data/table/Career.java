package ccm.data.table;

import java.util.Date;

public class Career
{
	/*
	CNUM BIGINT NOT NULL AUTO_INCREMENT, #경력번호
  COMPANY VARCHAR(15) NOT NULL, #근무회사
  JOINDATE DATE NOT NULL, #입사일
  DROPDATE DATE NULL, #퇴사일(예정일)
  POSITION VARCHAR(15) NOT NULL, #직위
  JOB VARCHAR(15) NOT NULL, #담당업무
  FID VARCHAR(15) NULL, #프리랜서아이디
  EID VARCHAR(15) NULL, #직원아이디
	*/
	
	private int careerNum;			// 경력번호
	private String careerCompany;	// 근무회사
	private Date companyJoinDate;	// 입사일
	private Date companyDropDate;	// 퇴사일
	private String careerPosition;	// 직위
	private String careerJob;		// 담당업무
	private String freeId;			// 프리랜서 아이디
	private String empId;			// 사원 아이디
	
	public Career() { super(); }
	public Career(int cNum, String company, Date joinDate, Date dropDate, String position, String job, String fId,
			String eId)
	{
		super();
		this.careerNum = cNum;
		this.careerCompany = company;
		this.companyJoinDate = joinDate;
		this.companyDropDate = dropDate;
		this.careerPosition = position;
		this.careerJob = job;
		this.freeId = fId;
		this.empId = eId;
	}
	public int getCareerNum() {
		return careerNum;
	}
	public void setCareerNum(int careerNum) {
		this.careerNum = careerNum;
	}
	public String getCareerCompany() {
		return careerCompany;
	}
	public void setCareerCompany(String careerCompany) {
		this.careerCompany = careerCompany;
	}
	public Date getCompanyJoinDate() {
		return companyJoinDate;
	}
	public void setCompanyJoinDate(Date companyJoinDate) {
		this.companyJoinDate = companyJoinDate;
	}
	public Date getCompanyDropDate() {
		return companyDropDate;
	}
	public void setCompanyDropDate(Date companyDropDate) {
		this.companyDropDate = companyDropDate;
	}
	public String getCareerPosition() {
		return careerPosition;
	}
	public void setCareerPosition(String careerPosition) {
		this.careerPosition = careerPosition;
	}
	public String getCareerJob() {
		return careerJob;
	}
	public void setCareerJob(String careerJob) {
		this.careerJob = careerJob;
	}
	public String getFreeId() {
		return freeId;
	}
	public void setFreeId(String freeId) {
		this.freeId = freeId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
}
