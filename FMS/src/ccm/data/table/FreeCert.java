package ccm.data.table;

import java.sql.Date;

public class FreeCert
{
	/*
	CNUM BIGINT NOT NULL, #자격증번호
  FID VARCHAR(15) NOT NULL, #프리랜서아이디
  GETDATE DATE NOT NULL, #취득일
	*/
	
	private Integer cNum;
	private String freeId;
	private Date getDate;
	
	public Integer getcNum() {
		return cNum;
	}
	public void setcNum(Integer cNum) {
		this.cNum = cNum;
	}
	public String getFreeId() {
		return freeId;
	}
	public void setFreeId(String freeId) {
		this.freeId = freeId;
	}
	public Date getGetDate() {
		return getDate;
	}
	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}
}
