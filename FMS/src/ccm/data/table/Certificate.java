package ccm.data.table;

public class Certificate
{
	
	private Integer certNum;		// 자격증 번호
	private String certInstitute;	// 발급기관
	private String certName;			// 자격증 이름
	
	public Certificate() {
		super();
	}
	
	public Certificate(Integer certNum, String certInstitute, String certName) {
		this.certNum = certNum;
		this.certInstitute = certInstitute;
		this.certName = certName;
	}
	
	public Integer getCertNum() {
		return certNum;
	}
	public void setCertNum(Integer certNum) {
		this.certNum = certNum;
	}
	public String getCertInstitute() {
		return certInstitute;
	}
	public void setCertInstitute(String certInstitute) {
		this.certInstitute = certInstitute;
	}
	public String getCertName() {
		return certName;
	}
	public void setCertName(String certName) {
		this.certName = certName;
	}
}
