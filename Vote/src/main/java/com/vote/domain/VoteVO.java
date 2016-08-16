package com.vote.domain;

import java.util.Date;

public class VoteVO {

	private Integer vidx;
	private String vwriter;
	private String vtitle;
	private String vactive;
	private String vstatus;
	private Date vupdatedate;


	public Integer getVidx() {
		return vidx;
	}


	public void setVidx(Integer vidx) {
		this.vidx = vidx;
	}


	public String getVwriter() {
		return vwriter;
	}


	public void setVwriter(String vwriter) {
		this.vwriter = vwriter;
	}


	public String getVtitle() {
		return vtitle;
	}


	public void setVtitle(String vtitle) {
		this.vtitle = vtitle;
	}


	public String getVactive() {
		return vactive;
	}


	public void setVactive(String vactive) {
		this.vactive = vactive;
	}


	public String getVstatus() {
		return vstatus;
	}


	public void setVstatus(String vstatus) {
		this.vstatus = vstatus;
	}


	public Date getVupdatedate() {
		return vupdatedate;
	}


	public void setVupdatedate(Date vupdatedate) {
		this.vupdatedate = vupdatedate;
	}


	@Override
	public String toString() {
		return "VoteVO [V_IDX=" + vidx + ", V_WRITER=" + vwriter + ", V_TITLE="
				+ vtitle + ", V_ACTIVE=" + vactive + ", V_STATUS=" + vstatus
				+ ", V_UPDATE_DATE=" + vupdatedate + "]";
	}
}
