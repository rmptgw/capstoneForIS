package ccm.data.table;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/***************************
 * 
 * 
 * 프리랜서 기본정보
 * int형은 nullable이어야되니까 Integer 자료형으로 쓰도록
 * 
 * 작성자 : 
 * 
 * 수정자 : 
 * 
 * 수정일 : 
 *
 *
 ***************************/

public class Freelancer
{
	private String freeId;			// 프리랜서 아이디
	private String freePw;			// 프리랜서 비밀번호
	private String freeName;		// 프리랜서 이름
	private String freePic;			// 프리랜서 사진
	private Date freeBirth;			// 프리랜서 생년월일
	private Boolean freesex;		// 프리랜서 성별
	private String freePhone;		// 프리랜서 전화번호
	private String freeEmail;		// 프리랜서 이메일
	private Date freeJoinDate;		// 프리랜서 가입일
	private Date freeDropDate;		// 프리랜서 탈퇴일
	private Integer freeClass;		// 프리랜서 회원등급
	private Integer freeKosa;		// 프리랜서 코사등급
	private Boolean freeMarried;	// 프리랜서 결혼 유무
	private String freeFrontAddr;	// 프리랜서 주소
	private String freeRearAddr;	// 프리랜서 상세주소
	private String freeBank;		// 프리랜서 은행
	private String freeAccName;		// 프리랜서 계좌명
	private String freeAccount;		// 프리랜서 계좌번호
	private String freeReviser;		// 프리랜서 수정자
	private Date freeReviseDate;	// 프리랜서 수정일
	private Integer freeScore;		// 프리랜서 점수
	
	public Freelancer()
	{
		super();
	}
	public Freelancer(String freeId, String freePw, String freeEmail)
	{
		super();
		this.freeId = freeId;
		this.freePw = freePw;
		this.freeEmail = freeEmail;
	}
	public Freelancer(String freeId, String freePw, String freeName, String freePic, Date freeBirth, Boolean freesex,
			String freePhone, String freeEmail, Date freeJoinDate, Date freeDropDate, Integer freeClass,
			Integer freeKosa, Boolean freeMarried, String freeFrontAddr, String freeRearAddr, String freeBank,
			String freeAccName, String freeAccount, String freeReviser, Date freeReviseDate)
	{
		super();
		this.freeId = freeId;
		this.freePw = freePw;
		this.freeName = freeName;
		this.freePic = freePic;
		this.freeBirth = freeBirth;
		this.freesex = freesex;
		this.freePhone = freePhone;
		this.freeEmail = freeEmail;
		this.freeJoinDate = freeJoinDate;
		this.freeDropDate = freeDropDate;
		this.freeClass = freeClass;
		this.freeKosa = freeKosa;
		this.freeMarried = freeMarried;
		this.freeFrontAddr = freeFrontAddr;
		this.freeRearAddr = freeRearAddr;
		this.freeBank = freeBank;
		this.freeAccName = freeAccName;
		this.freeAccount = freeAccount;
		this.freeReviser = freeReviser;
		this.freeReviseDate = freeReviseDate;
	}
	
	public void setParams(ResultSet rs) throws SQLException
	{
		this.freeId = rs.getString("FREEID");
		this.freePw = rs.getString("FREEPW");
		this.freeName = rs.getString("FREENAME");
		this.freePic = rs.getString("FREEPIC");
		this.freeBirth = rs.getDate("FREEBIRTH");
		this.freesex = rs.getBoolean("FREESEX");
		this.freePhone = rs.getString("FREEPHONE");
		this.freeEmail = rs.getString("FREEEMAIL");
		this.freeJoinDate = rs.getDate("FREEJOINDATE");
		this.freeDropDate = rs.getDate("FREEDROPDATE");
		this.freeClass = rs.getInt("FREECLASS");
		this.freeKosa = rs.getInt("FREEKOSA");
		this.freeMarried = rs.getBoolean("FREEMARRIED");
		this.freeFrontAddr = rs.getString("FREEFRONTADDR");
		this.freeRearAddr = rs.getString("FREEREARADDR");
		this.freeBank = rs.getString("FREEBANK");
		this.freeAccName = rs.getString("FREEACCNAME");
		this.freeAccount = rs.getString("FREEACCOUNT");
		this.freeReviser = rs.getString("FREEREVISER");
		this.freeReviseDate = rs.getDate("FREEREVISEDATE");
	}
	
	public String getFreeId() { return freeId; }
	public void setFreeId(String freeId) { this.freeId = freeId; }
	public String getFreePw() { return freePw; }
	public void setFreePw(String freePw) { this.freePw = freePw; }
	public String getFreeName() { return freeName; }
	public void setFreeName(String freeName) { this.freeName = freeName; }
	public String getFreePic() { return freePic; }
	public void setFreePic(String freePic) { this.freePic = freePic; }
	public Date getFreeBirth() { return freeBirth; }
	public void setFreeBirth(Date freeBirth) { this.freeBirth = freeBirth; }
	public Boolean getFreesex() { return freesex; }
	public void setFreesex(Boolean freesex) { this.freesex = freesex; }
	public String getFreePhone() { return freePhone; }
	public void setFreePhone(String freePhone) { this.freePhone = freePhone; }
	public String getFreeEmail() { return freeEmail; }
	public void setFreeEmail(String freeEmail) { this.freeEmail = freeEmail; }
	public Date getFreeJoinDate() { return freeJoinDate; }
	public void setFreeJoinDate(Date freeJoinDate) { this.freeJoinDate = freeJoinDate; }
	public Date getFreeDropDate() { return freeDropDate; }
	public void setFreeDropDate(Date freeDropDate) { this.freeDropDate = freeDropDate; }
	public Integer getFreeClass() { return freeClass; }
	public void setFreeClass(Integer freeClass) { this.freeClass = freeClass; }
	public Integer getFreeKosa() { return freeKosa; }
	public void setFreeKosa(Integer freeKosa) { this.freeKosa = freeKosa; }
	public Boolean getFreeMarried() { return freeMarried; }
	public void setFreeMarried(Boolean freeMarried) { this.freeMarried = freeMarried; }
	public String getFreeFrontAddr() { return freeFrontAddr; }
	public void setFreeFrontAddr(String freeFrontAddr) { this.freeFrontAddr = freeFrontAddr; }
	public String getFreeRearAddr() { return freeRearAddr; }
	public void setFreeRearAddr(String freeRearAddr) { this.freeRearAddr = freeRearAddr; }
	public String getFreeBank() { return freeBank; }
	public void setFreeBank(String freeBank) { this.freeBank = freeBank; }
	public String getFreeAccName() { return freeAccName; }
	public void setFreeAccName(String freeAccName) { this.freeAccName = freeAccName; }
	public String getFreeAccount() { return freeAccount; }
	public void setFreeAccount(String freeAccount) { this.freeAccount = freeAccount; }
	public String getFreeReviser() { return freeReviser; }
	public void setFreeReviser(String freeReviser) { this.freeReviser = freeReviser; }
	public Date getFreeReviseDate() { return freeReviseDate; }
	public void setFreeReviseDate(Date freeReviseDate) { this.freeReviseDate = freeReviseDate; }
	public Integer getFreeScore() {
		return freeScore;
	}
	public void setFreeScore(Integer freeScore) {
		this.freeScore = freeScore;
	}
	@Override
	public String toString() {
		return "Freelancer [freeId=" + freeId + ", freePw=" + freePw + ", freeName=" + freeName + ", freePic=" + freePic
				+ ", freeBirth=" + freeBirth + ", freesex=" + freesex + ", freePhone=" + freePhone + ", freeEmail="
				+ freeEmail + ", freeJoinDate=" + freeJoinDate + ", freeDropDate=" + freeDropDate + ", freeClass="
				+ freeClass + ", freeKosa=" + freeKosa + ", freeMarried=" + freeMarried + ", freeFrontAddr="
				+ freeFrontAddr + ", freeRearAddr=" + freeRearAddr + ", freeBank=" + freeBank + ", freeAccName="
				+ freeAccName + ", freeAccount=" + freeAccount + ", freeReviser=" + freeReviser + ", freeReviseDate="
				+ freeReviseDate + ", freeScore=" + freeScore + "]";
	}
	
	
}
