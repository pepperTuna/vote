package com.vote.domain;

import java.util.Date;

public class VoteVO {
	
	private Integer V_IDX;
	private String V_WRITER;
	private String V_TITLE;
	private String V_ACTIVE;
	private String V_STATUS;
	private Date V_UPDATE_DATE;
	
		
	public Integer getV_IDX() {
		return V_IDX;
	}

	public void setV_IDX(Integer v_IDX) {
		V_IDX = v_IDX;
	}

	public String getV_WRITER() {
		return V_WRITER;
	}

	public void setV_WRITER(String v_WRITER) {
		V_WRITER = v_WRITER;
	}

	public String getV_TITLE() {
		return V_TITLE;
	}

	public void setV_TITLE(String v_TITLE) {
		V_TITLE = v_TITLE;
	}

	public String getV_ACTIVE() {
		return V_ACTIVE;
	}

	public void setV_ACTIVE(String v_ACTIVE) {
		V_ACTIVE = v_ACTIVE;
	}

	public String getV_STATUS() {
		return V_STATUS;
	}

	public void setV_STATUS(String v_STATUS) {
		V_STATUS = v_STATUS;
	}

	public Date getV_UPDATE_DATE() {
		return V_UPDATE_DATE;
	}

	public void setV_UPDATE_DATE(Date v_UPDATE_DATE) {
		V_UPDATE_DATE = v_UPDATE_DATE;
	}

	@Override
	public String toString() {
		return "VoteVO [V_IDX=" + V_IDX + ", V_WRITER=" + V_WRITER + ", V_TITLE="
				+ V_TITLE + ", V_ACTIVE=" + V_ACTIVE + ", V_STATUS=" + V_STATUS
				+ ", V_UPDATE_DATE=" + V_UPDATE_DATE + "]";
	}
}
