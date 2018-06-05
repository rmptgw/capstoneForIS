package ccm.data.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class Project
{
	protected String projNum;				// 프로젝트 번호
	protected String projCompany;			// 프로젝트 시행 회사
	protected boolean isExtern;			// 외부 프로젝트 유무
	protected String projField;			// 프로젝트 유형(SM or SI)
	protected String projName;			// 프로젝트 이름
	protected String projState;			// 프로젝트 진행상태
	protected Date projRegisterDate;		// 프로젝트 등록일
	protected String projRegisterer;		// 프로젝트 등록자
	protected Date projReviseDate;		// 프로젝트 수정일
	protected String projReviser;			// 프로젝트 수정자
	protected Date projStartDate;			// 프로젝트 시작일
	protected Date projEndDate;			// 프로젝트 종료일
	protected int projExpectedTime;		// 프로젝트 예상기간
	protected String projTarget;			// 프로젝트 고객사
	protected String projPartner;			// 프로젝트 협력사
	protected String projPlan;			// 프로젝트 세부내용
	protected Date projRecruitStartDate;	// 프로젝트 인원 모집 시작일
	protected Date projRecruitEndDate;	// 프로젝트 인원 모집 종료일
	protected String projDevelopSort;		// 개발 분야
	protected Integer dbNum;				// 사용 DB번호
	
	public Project()
	{
		super();
	}
	public Project(String projNum, String projCompany, boolean isExtern, String projField, String projName,
			String projState, Date projRegisterDate, String projRegisterer, Date projReviseDate, String projReviser,
			Date projStartDate, Date projEndDate, int projExpectedTime, String projTarget, String projPartner,
			String projPlan, Date projRecruitStartDate, Date projRecruitEndDate, String projDevelopSort,
			Integer dbNum)
	{
		super();
		this.projNum = projNum;
		this.projCompany = projCompany;
		this.isExtern = isExtern;
		this.projField = projField;
		this.projName = projName;
		this.projState = projState;
		this.projRegisterDate = projRegisterDate;
		this.projRegisterer = projRegisterer;
		this.projReviseDate = projReviseDate;
		this.projReviser = projReviser;
		this.projStartDate = projStartDate;
		this.projEndDate = projEndDate;
		this.projExpectedTime = projExpectedTime;
		this.projTarget = projTarget;
		this.projPartner = projPartner;
		this.projPlan = projPlan;
		this.projRecruitStartDate = projRecruitStartDate;
		this.projRecruitEndDate = projRecruitEndDate;
		this.projDevelopSort = projDevelopSort;
		this.dbNum = dbNum;
	}
	
	public void setParams(ResultSet rs) throws SQLException
	{
		this.projNum = rs.getString("PROJNUM");
		this.projCompany = rs.getString("PROJCOMPANY");
		this.isExtern = rs.getBoolean("ISEXTERN");
		this.projField = rs.getString("PROJFIELD");
		this.projName = rs.getString("PROJNAME");
		this.projState = rs.getString("PROJSTATE");
		this.projRegisterDate = rs.getDate("PROJREGISTERDATE");
		this.projRegisterer = rs.getString("PROJREGISTERER");
		this.projReviseDate = rs.getDate("PROJREVISEDATE");
		this.projReviser = rs.getString("PROJREVISER");
		this.projStartDate = rs.getDate("PROJSTARTDATE");
		this.projEndDate = rs.getDate("PROJENDDATE");
		this.projExpectedTime = rs.getInt("PROJEXPECTEDTIME");
		this.projTarget = rs.getString("PROJTARGET");
		this.projPartner = rs.getString("PROJPARTNER");
		this.projPlan = rs.getString("PROJPLAN");
		this.projRecruitStartDate = rs.getDate("PROJRECRUITSTARTDATE");
		this.projRecruitEndDate = rs.getDate("PROJRECRUITENDDATE");
		this.projDevelopSort = rs.getString("PROJDEVELOPSORT");
		this.dbNum = rs.getInt("DBNUM");
	}
	
	public String getProjNum() { return projNum; }
	public void setProjNum(String projNum) { this.projNum = projNum; }
	public String getProjCompany() { return projCompany; }
	public void setProjCompany(String projCompany) { this.projCompany = projCompany; }
	public boolean isExtern() { return isExtern; }
	public void setExtern(boolean isExtern) { this.isExtern = isExtern; }
	public String getProjField() { return projField; }
	public void setProjField(String projField) { this.projField = projField; }
	public String getProjName() { return projName; }
	public void setProjName(String projName) { this.projName = projName; }
	public String getProjState() { return projState; }
	public void setProjState(String projState) { this.projState = projState; }
	public Date getProjRegisterDate() { return projRegisterDate; }
	public void setProjRegisterDate(Date projRegisterDate) { this.projRegisterDate = projRegisterDate; }
	public String getProjRegisterer() { return projRegisterer; }
	public void setProjRegisterer(String projRegisterer) { this.projRegisterer = projRegisterer; }
	public Date getProjReviseDate() { return projReviseDate; }
	public void setProjReviseDate(Date projReviseDate) { this.projReviseDate = projReviseDate; }
	public String getProjReviser() { return projReviser; }
	public void setProjReviser(String projReviser) { this.projReviser = projReviser; }
	public Date getProjStartDate() { return projStartDate; }
	public void setProjStartDate(Date projStartDate) { this.projStartDate = projStartDate; }
	public Date getProjEndDate() { return projEndDate; }
	public void setProjEndDate(Date projEndDate) { this.projEndDate = projEndDate; }
	public int getProjExpectedTime() { return projExpectedTime; }
	public void setProjExpectedTime(int projExpectedTime) { this.projExpectedTime = projExpectedTime; }
	public String getProjTarget() { return projTarget; }
	public void setProjTarget(String projTarget) { this.projTarget = projTarget; }
	public String getProjPartner() { return projPartner; }
	public void setProjPartner(String projPartner) { this.projPartner = projPartner; }
	public String getProjPlan() { return projPlan; }
	public void setProjPlan(String projPlan) { this.projPlan = projPlan; }
	public Date getProjRecruitStartDate() { return projRecruitStartDate; }
	public void setProjRecruitStartDate(Date projRecruitStartDate) { this.projRecruitStartDate = projRecruitStartDate; }
	public Date getProjRecruitEndDate() { return projRecruitEndDate; }
	public void setProjRecruitEndDate(Date projRecruitEndDate) { this.projRecruitEndDate = projRecruitEndDate; }
	public String getProjDevelopSort() { return projDevelopSort; }
	public void setProjDevelopSort(String projDevelopSort) { this.projDevelopSort = projDevelopSort; }
	public Integer getDbNum() { return dbNum; }
	public void setDbNum(Integer dbNum) { this.dbNum = dbNum; }
	@Override
	public String toString() {
		return "Project [projNum=" + projNum + ", projCompany=" + projCompany + ", isExtern=" + isExtern
				+ ", projField=" + projField + ", projName=" + projName + ", projState=" + projState
				+ ", projRegisterDate=" + projRegisterDate + ", projRegisterer=" + projRegisterer + ", projReviseDate="
				+ projReviseDate + ", projReviser=" + projReviser + ", projStartDate=" + projStartDate
				+ ", projEndDate=" + projEndDate + ", projExpectedTime=" + projExpectedTime + ", projTarget="
				+ projTarget + ", projPartner=" + projPartner + ", projPlan=" + projPlan + ", projRecruitStartDate="
				+ projRecruitStartDate + ", projRecruitEndDate=" + projRecruitEndDate + ", projDevelopSort="
				+ projDevelopSort + ", dbNum=" + dbNum + "]";
	}
}
