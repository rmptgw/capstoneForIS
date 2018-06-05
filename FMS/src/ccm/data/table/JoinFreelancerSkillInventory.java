package ccm.data.table;

public class JoinFreelancerSkillInventory{
	
	private String joinNum;
	private String freeId;
	private String freeName;
	private String freeState;
	private String languages;
	private String frameworks;
	private String careerYear;
	private String joinProjTime;
	private String freeKosa;
	private String freeScore;
	
	public String getJoinNum() {
		return joinNum;
	}
	public void setJoinNum(String joinNum) {
		this.joinNum = joinNum;
	}
	public String getFreeId() {
		return freeId;
	}
	public void setFreeId(String freeId) {
		this.freeId = freeId;
	}
	public String getFreeName() {
		return freeName;
	}
	public void setFreeName(String freeName) {
		this.freeName = freeName;
	}
	public String getFreeState() {
		return freeState;
	}
	public void setFreeState(String freeState) {
		this.freeState = freeState;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getFrameworks() {
		return frameworks;
	}
	public void setFrameworks(String frameworks) {
		this.frameworks = frameworks;
	}
	public String getCareerYear() {
		return careerYear;
	}
	public void setCareerYear(String careerYear) {
		this.careerYear = careerYear;
	}
	public String getJoinProjTime() {
		return joinProjTime;
	}
	public void setJoinProjTime(String joinProjTime) {
		this.joinProjTime = joinProjTime;
	}
	public String getFreeKosa() {
		return freeKosa;
	}
	public void setFreeKosa(String freeKosa) {
		this.freeKosa = freeKosa;
	}
	public String getFreeScore() {
		return freeScore;
	}
	public void setFreeScore(String freeScore) {
		this.freeScore = freeScore;
	}
	@Override
	public String toString() {
		return "JoinFreelancerSkillInventory [joinNum=" + joinNum + ", freeId=" + freeId + ", freeName=" + freeName
				+ ", freeState=" + freeState + ", languages=" + languages + ", frameworks=" + frameworks
				+ ", careerYear=" + careerYear + ", joinProjTime=" + joinProjTime + ", freeKosa=" + freeKosa
				+ ", freeScore=" + freeScore + "]";
	}
	
}
