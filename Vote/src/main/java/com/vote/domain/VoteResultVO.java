package com.vote.domain;

public class VoteResultVO {

	private String rUser;
	private Integer vNo;
	private Integer qNo;
	private Integer cNo;
	private String vUpdateDate;
	
	public String getrUser() {
		return rUser;
	}

	public void setrUser(String rUser) {
		this.rUser = rUser;
	}

	public Integer getvNo() {
		return vNo;
	}

	public void setvNo(Integer vNo) {
		this.vNo = vNo;
	}

	public Integer getqNo() {
		return qNo;
	}

	public void setqNo(Integer qNo) {
		this.qNo = qNo;
	}

	public Integer getcNo() {
		return cNo;
	}

	public void setcNo(Integer cNo) {
		this.cNo = cNo;
	}

	public String getvUpdateDate() {
		return vUpdateDate;
	}

	public void setvUpdateDate(String vUpdateDate) {
		this.vUpdateDate = vUpdateDate;
	}

	@Override
	public String toString() {
		return "ResultVO [R_USER=" + rUser + ", V_NO=" + vNo + ", Q_NO="
				+ qNo + ", C_NO=" + cNo + ", V_UPDATE_DATE=" + vUpdateDate + "]";
	}
}
