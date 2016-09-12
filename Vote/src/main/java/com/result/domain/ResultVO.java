package com.result.domain;
//
public class ResultVO {
	private Integer ridx;
	private String ruser;
	private Integer vno;
	private Integer qno;
	private Integer cno;
	private String vupdatedate;

	public Integer getRidx() {
		return ridx;
	}
	
	public void setRidx(Integer ridx) {
		this.ridx = ridx;
	}

	public String getRuser() {
		return ruser;
	}

	public void setRuser(String ruser) {
		this.ruser = ruser;
	}
	
	public Integer getVno() {
		return vno;
	}
	
	public void setVno(Integer vno) {
		this.vno = vno;
	}

	public Integer getQno() {
		return qno;
	}

	public void setQno(Integer qno) {
		this.qno = qno;
	}

	public Integer getCno() {
		return cno;
	}
	
	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public String getVupdatedate() {
		return vupdatedate;
	}

	public void setVupdatedate(String vupdatedate) {
		this.vupdatedate = vupdatedate;
	}

	@Override
	public String toString() {
		return "ResultVO [R_USER=" + ruser + ", V_NO=" + vno + ", Q_NO="
				+ qno + ", C_NO=" + cno + ", V_UPDATE_DATE=" + vupdatedate + "]";
	}
}
