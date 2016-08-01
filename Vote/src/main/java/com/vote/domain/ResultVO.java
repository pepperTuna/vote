package com.vote.domain;

public class ResultVO {

	private String R_USER;
	private Integer V_NO;
	private Integer Q_NO;
	private Integer C_NO;
	private String V_UPDATE_DATE;
	
	public String getR_USER() {
		return R_USER;
	}
	
	public void setR_USER(String r_USER) {
		R_USER = r_USER;
	}
	
	public Integer getV_NO() {
		return V_NO;
	}
	
	public void setV_NO(Integer v_NO) {
		V_NO = v_NO;
	}
	
	public Integer getQ_NO() {
		return Q_NO;
	}
	
	public void setQ_NO(Integer q_NO) {
		Q_NO = q_NO;
	}
	
	public Integer getC_NO() {
		return C_NO;
	}
	
	public void setC_NO(Integer c_NO) {
		C_NO = c_NO;
	}
	
	public String getV_UPDATE_DATE() {
		return V_UPDATE_DATE;
	}
	
	public void setV_UPDATE_DATE(String v_UPDATE_DATE) {
		V_UPDATE_DATE = v_UPDATE_DATE;
	}

	@Override
	public String toString() {
		return "ResultVO [R_USER=" + R_USER + ", V_NO=" + V_NO + ", Q_NO="
				+ Q_NO + ", C_NO=" + C_NO + ", V_UPDATE_DATE=" + V_UPDATE_DATE + "]";
	}
}
