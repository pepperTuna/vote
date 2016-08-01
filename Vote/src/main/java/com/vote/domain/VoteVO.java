package com.vote.domain;

import java.util.Date;

public class VoteVO {
	
	private Integer vIdx;
	private String vWriter;
	private String vTitle;
	private String vActive;
	private String vStatus;
	private Date vUpdateDate;
	
		
	public Integer getV_IDX() {
		return vIdx;
	}

	public void setV_IDX(Integer v_IDX) {
		vIdx = v_IDX;
	}

	public String getV_WRITER() {
		return vWriter;
	}

	public void setV_WRITER(String v_WRITER) {
		vWriter = v_WRITER;
	}

	public String getV_TITLE() {
		return vTitle;
	}

	public void setV_TITLE(String v_TITLE) {
		vTitle = v_TITLE;
	}

	public String getV_ACTIVE() {
		return vActive;
	}

	public void setV_ACTIVE(String v_ACTIVE) {
		vActive = v_ACTIVE;
	}

	public String getV_STATUS() {
		return vStatus;
	}

	public void setV_STATUS(String v_STATUS) {
		vStatus = v_STATUS;
	}

	public Date getV_UPDATE_DATE() {
		return vUpdateDate;
	}

	public void setV_UPDATE_DATE(Date v_UPDATE_DATE) {
		vUpdateDate = v_UPDATE_DATE;
	}

	@Override
	public String toString() {
		return "VoteVO [V_IDX=" + vIdx + ", V_WRITER=" + vWriter + ", V_TITLE="
				+ vTitle + ", V_ACTIVE=" + vActive + ", V_STATUS=" + vStatus
				+ ", V_UPDATE_DATE=" + vUpdateDate + "]";
	}
}
