package ccm.data.table;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/***************************
 * 
 * 
 * 지권 지건
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

public class Employee
{
	
	private String empId;			// 사원 아이디
	private String empPw;			// 사원 비밀번호
	private String empDuty;			// 사원 직책
	private String empName;			// 사원 이름
	private String empDept;			// 사원 부서
	private String empPicture;		// 사원 사진
	private Date empJoinDate;		// 사원 입사일
	private Date empDropDate;		// 사원 퇴사일
	private String empPhone;		// 사원 전화번호
	private String empEmail;		// 사원 이메일
	private Date empBirth;			// 사원 생일
	private Boolean empSex;			// 사원 성별
	private Boolean empMarried;		// 사원 결혼 여부
	private String empFrontAddr;	// 사원 주소
	private String empRearAddr;		// 사원 상세주소
	private String empBank;			// 사원 은행
	private String empAccName;		// 사원 계좌번호 이름
	private String empAccount;		// 사원 계좌번호
	private Integer empAuth;		// 사원 권한
	
	public Employee()
	{
		super();
	}
	public Employee(String empId, String empPw, String empDuty, String empName, String empDept, String empPicture,
			Date empJoinDate, Date empDropDate, String empPhone, String empEmail, Date empBirth, Boolean empSex,
			Boolean empMarried, String empFrontAddr, String empRearAddr, String empBank, String empAccName,
			String empAccount, Integer empAuth)
	{
		super();
		this.empId = empId;
		this.empPw = empPw;
		this.empDuty = empDuty;
		this.empName = empName;
		this.empDept = empDept;
		this.empPicture = empPicture;
		this.empJoinDate = empJoinDate;
		this.empDropDate = empDropDate;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
		this.empBirth = empBirth;
		this.empSex = empSex;
		this.empMarried = empMarried;
		this.empFrontAddr = empFrontAddr;
		this.empRearAddr = empRearAddr;
		this.empBank = empBank;
		this.empAccName = empAccName;
		this.empAccount = empAccount;
		this.empAuth = empAuth;
	}
	public void setParams(ResultSet rs) throws SQLException
	{
		this.empId = rs.getString("EMPID");
		this.empPw = rs.getString("EMPPW");
		this.empDuty = rs.getString("EMPDUTY");
		this.empName = rs.getString("EMPNAME");
		this.empDept = rs.getString("EMPDEPT");
		this.empPicture = rs.getString("EMPPICTURE");
		this.empJoinDate = rs.getDate("EMPJOINDATE");
		this.empDropDate = rs.getDate("EMPDROPDATE");
		this.empPhone = rs.getString("EMPPHONE");
		this.empEmail = rs.getString("EMPEMAIL");
		this.empBirth = rs.getDate("EMPBIRTH");
		this.empSex = rs.getBoolean("EMPSEX");
		this.empMarried = rs.getBoolean("EMPMARRIED");
		this.empFrontAddr = rs.getString("EMPFRONTADDR");
		this.empRearAddr = rs.getString("EMPREARADDR");
		this.empBank = rs.getString("EMPBANK");
		this.empAccName = rs.getString("EMPACCNAME");
		this.empAccount = rs.getString("EMPACCOUNT");
		this.empAuth = rs.getInt("EMPAUTH");
	}

	public String getEmpId() { return empId; }
	public void setEmpId(String empId) { this.empId = empId; }
	public String getEmpPw() { return empPw; }
	public void setEmpPw(String empPw) { this.empPw = empPw; }
	public String getEmpDuty() { return empDuty; }
	public void setEmpDuty(String empDuty) { this.empDuty = empDuty; }
	public String getEmpName() { return empName; }
	public void setEmpName(String empName) { this.empName = empName; }
	public String getEmpDept() { return empDept; }
	public void setEmpDept(String empDept) { this.empDept = empDept; }
	public String getEmpPicture() { return empPicture; }
	public void setEmpPicture(String empPicture) { this.empPicture = empPicture; }
	public Date getEmpJoinDate() { return empJoinDate; }
	public void setEmpJoinDate(Date empJoinDate) { this.empJoinDate = empJoinDate; }
	public Date getEmpDropDate() { return empDropDate; }
	public void setEmpDropDate(Date empDropDate) { this.empDropDate = empDropDate; }
	public String getEmpPhone() { return empPhone; }
	public void setEmpPhone(String empPhone) { this.empPhone = empPhone; }
	public String getEmpEmail() { return empEmail; }
	public void setEmpEmail(String empEmail) { this.empEmail = empEmail; }
	public Date getEmpBirth() { return empBirth; }
	public void setEmpBirth(Date empBirth) { this.empBirth = empBirth; }
	public Boolean getEmpSex() { return empSex; }
	public void setEmpSex(Boolean empSex) { this.empSex = empSex; }
	public Boolean getEmpMarried() { return empMarried; }
	public void setEmpMarried(Boolean empMarried) { this.empMarried = empMarried; }
	public String getEmpFrontAddr() { return empFrontAddr; }
	public void setEmpFrontAddr(String empFrontAddr) { this.empFrontAddr = empFrontAddr; }
	public String getEmpRearAddr() { return empRearAddr; }
	public void setEmpRearAddr(String empRearAddr) { this.empRearAddr = empRearAddr; }
	public String getEmpBank() { return empBank; }
	public void setEmpBank(String empBank) { this.empBank = empBank; }
	public String getEmpAccName() { return empAccName; }
	public void setEmpAccName(String empAccName) { this.empAccName = empAccName; }
	public String getEmpAccount() { return empAccount; }
	public void setEmpAccount(String empAccount) { this.empAccount = empAccount; }
	public Integer getEmpAuth() { return empAuth; }
	public void setEmpAuth(Integer empAuth) { this.empAuth = empAuth; }
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empPw=" + empPw + ", empDuty=" + empDuty + ", empName=" + empName
				+ ", empDept=" + empDept + ", empPicture=" + empPicture + ", empJoinDate=" + empJoinDate
				+ ", empDropDate=" + empDropDate + ", empPhone=" + empPhone + ", empEmail=" + empEmail + ", empBirth="
				+ empBirth + ", empSex=" + empSex + ", empMarried=" + empMarried + ", empFrontAddr=" + empFrontAddr
				+ ", empRearAddr=" + empRearAddr + ", empBank=" + empBank + ", empAccName=" + empAccName
				+ ", empAccount=" + empAccount + ", empAuth=" + empAuth + "]";
	}
}
