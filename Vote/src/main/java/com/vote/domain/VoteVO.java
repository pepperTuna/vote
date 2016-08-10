package com.vote.domain;

import java.util.Date;

public class VoteVO {

	private Integer vidx;
	private String vWriter;
	private String vTitle;
	private String vActive;
	private String vStatus;
	private Date vUpdateDate;
	
	public Integer getvidx() {
		return vidx;
	}
	
	public void setvidx(Integer vIdx) {
		this.vidx = vIdx;
	}
	
	public String getvWriter() {
		return vWriter;
	}
	
	public void setvWriter(String vWriter) {
		this.vWriter = vWriter;
	}
	
	public String getvTitle() {
		return vTitle;
	}
	
	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}
	
	public String getvActive() {
		return vActive;
	}
	
	public void setvActive(String vActive) {
		this.vActive = vActive;
	}
	
	public String getvStatus() {
		return vStatus;
	}
	
	public void setvStatus(String vStatus) {
		this.vStatus = vStatus;
	}
	
	public Date getvUpdateDate() {
		return vUpdateDate;
	}
	
	public void setvUpdateDate(Date vUpdateDate) {
		this.vUpdateDate = vUpdateDate;
	}

	@Override
	public String toString() {
		return "VoteVO [V_IDX=" + vidx + ", V_WRITER=" + vWriter + ", V_TITLE="
				+ vTitle + ", V_ACTIVE=" + vActive + ", V_STATUS=" + vStatus
				+ ", V_UPDATE_DATE=" + vUpdateDate + "]";
	}
}
