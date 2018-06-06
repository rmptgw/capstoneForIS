package ccm.data.table;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectInfo extends Project{
	private String frames;
	private String languages;
	private String requirePeople;
	private String joinPeople;
	private String dbName;
	
	public String getFrames() {
		return frames;
	}
	public void setFrames(String frames) {
		this.frames = frames;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getRequirePeople() {
		return requirePeople;
	}
	public void setRequirePeople(String requirePeople) {
		this.requirePeople = requirePeople;
	}
	public String getJoinPeople() {
		return joinPeople;
	}
	public void setJoinPeople(String joinPeople) {
		this.joinPeople = joinPeople;
	}
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	
	
	@Override
	public String toString() {
		return "ProjectInfo [frames=" + frames + ", languages=" + languages + ", requirePeople=" + requirePeople
				+ ", joinPeople=" + joinPeople + ", dbName=" + dbName + ", projNum=" + projNum + ", projCompany="
				+ projCompany + ", isExtern=" + isExtern + ", projField=" + projField + ", projName=" + projName
				+ ", projState=" + projState + ", projRegisterDate=" + projRegisterDate + ", projRegisterer="
				+ projRegisterer + ", projReviseDate=" + projReviseDate + ", projReviser=" + projReviser
				+ ", projStartDate=" + projStartDate + ", projEndDate=" + projEndDate + ", projExpectedTime="
				+ projExpectedTime + ", projTarget=" + projTarget + ", projPartner=" + projPartner + ", projPlan="
				+ projPlan + ", projRecruitStartDate=" + projRecruitStartDate + ", projRecruitEndDate="
				+ projRecruitEndDate + ", projDevelopSort=" + projDevelopSort + ", dbNum=" + dbNum + "]";
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
// --------------------------------------------------------------------------------------
		this.frames = rs.getString("frameWorks");
		this.languages = rs.getString("languages");
		this.requirePeople = rs.getString("requirePeople");
		this.joinPeople = rs.getString("joinPeople");
		this.dbName = rs.getString("dbName");
	}
}
