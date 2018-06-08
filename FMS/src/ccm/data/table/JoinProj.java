package ccm.data.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class JoinProj /*extends Project*/
{
	private String joinNum;			// 참여 번호
	private Date joinProjDate;		// 투입일
	private Date exitProjDate;		// 철수일
	private String projRole;		// 역할
	private String freeState;		// 프리랜서 상태
	private Date applicationDate;	// 신청일
	private Date joinAcceptDate;	// 접수일
	private String projNum;			// 프로젝트 번호
	private String freeId;			// 프리랜서 번호
	
	public String getJoinNum() {
		return joinNum;
	}
	public void setJoinNum(String joinNum) {
		this.joinNum = joinNum;
	}
	public Date getJoinProjDate() {
		return joinProjDate;
	}
	public void setJoinProjDate(Date joinProjDate) {
		this.joinProjDate = joinProjDate;
	}
	public Date getExitProjDate() {
		return exitProjDate;
	}
	public void setExitProjDate(Date exitProjDate) {
		this.exitProjDate = exitProjDate;
	}
	public String getProjRole() {
		return projRole;
	}
	public void setProjRole(String projRoll) {
		this.projRole = projRoll;
	}
	public String getFreeState() {
		return freeState;
	}
	public void setFreeState(String freeState) {
		this.freeState = freeState;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Date getJoinAcceptDate() {
		return joinAcceptDate;
	}
	public void setJoinAcceptDate(Date joinAcceptDate) {
		this.joinAcceptDate = joinAcceptDate;
	}
	public String getProjNum() {
		return projNum;
	}
	public void setProjNum(String projNum) {
		this.projNum = projNum;
	}
	public String getFreeId() {
		return freeId;
	}
	public void setFreeId(String freeId) {
		this.freeId = freeId;
	}
	
	
	/*@Override
	public String toString() {
		return "JoinProj [joinNum=" + joinNum + ", joinProjDate=" + joinProjDate + ", exitProjDate=" + exitProjDate
				+ ", projRole=" + projRole + ", freeState=" + freeState + ", applicationDate=" + applicationDate
				+ ", joinAcceptDate=" + joinAcceptDate + ", projNum=" + projNum + ", freeId=" + freeId
				+ ", projCompany=" + projCompany + ", isExtern=" + isExtern + ", projField=" + projField + ", projName="
				+ projName + ", projState=" + projState + ", projRegisterDate=" + projRegisterDate + ", projRegisterer="
				+ projRegisterer + ", projReviseDate=" + projReviseDate + ", projReviser=" + projReviser
				+ ", projStartDate=" + projStartDate + ", projEndDate=" + projEndDate + ", projExpectedTime="
				+ projExpectedTime + ", projTarget=" + projTarget + ", projPartner=" + projPartner + ", projPlan="
				+ projPlan + ", projRecruitStartDate=" + projRecruitStartDate + ", projRecruitEndDate="
				+ projRecruitEndDate + ", projDevelopSort=" + projDevelopSort + ", dbNum=" + dbNum + "]";
	}*/
	
	@Override
	public String toString() {
		return "JoinProj [joinNum=" + joinNum + ", joinProjDate=" + joinProjDate + ", exitProjDate=" + exitProjDate
				+ ", projRole=" + projRole + ", freeState=" + freeState + ", applicationDate=" + applicationDate
				+ ", joinAcceptDate=" + joinAcceptDate + ", projNum=" + projNum + ", freeId=" + freeId + "]";
	}
	public void setParams(ResultSet rs) throws SQLException
	{
		this.joinNum = rs.getString("joinNum");
		this.joinProjDate = rs.getDate("joinProjDate");
		this.exitProjDate = rs.getDate("exitProjDate");
		this.projRole = rs.getString("projRole");
		this.freeState = rs.getString("freeState");
		this.applicationDate = rs.getDate("applicationDate");
		this.joinAcceptDate = rs.getDate("joinAcceptDate");
		this.projNum = rs.getString("projNum");
		this.freeId = rs.getString("freeId");
	}
	
}
