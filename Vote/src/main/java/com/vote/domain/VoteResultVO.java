package com.vote.domain;

public class VoteResultVO {

	private String rUser;
	private Integer vNo;
	private Integer qNo;
	private Integer cNo;
	private String vUpdateDate;
	
	public String getR_USER() {
		return rUser;
	}
	
	public void setR_USER(String r_USER) {
		rUser = r_USER;
	}
	
	public Integer getV_NO() {
		return vNo;
	}
	
	public void setV_NO(Integer v_NO) {
		vNo = v_NO;
	}
	
	public Integer getQ_NO() {
		return qNo;
	}
	
	public void setQ_NO(Integer q_NO) {
		qNo = q_NO;
	}
	
	public Integer getC_NO() {
		return cNo;
	}
	
	public void setC_NO(Integer c_NO) {
		cNo = c_NO;
	}
	
	public String getV_UPDATE_DATE() {
		return vUpdateDate;
	}
	
	public void setV_UPDATE_DATE(String v_UPDATE_DATE) {
		vUpdateDate = v_UPDATE_DATE;
	}

	@Override
	public String toString() {
		return "ResultVO [R_USER=" + rUser + ", V_NO=" + vNo + ", Q_NO="
				+ qNo + ", C_NO=" + cNo + ", V_UPDATE_DATE=" + vUpdateDate + "]";
	}
}
