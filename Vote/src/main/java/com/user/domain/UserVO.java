package com.user.domain;

import java.util.Date;

public class UserVO {
	private String userid;
	private String userpw;
	private String username;
	private String snsid;
	private String snstype;
	private char active;
	private Date regdate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSnsid() {
		return snsid;
	}
	public void setSnsid(String snsid) {
		this.snsid = snsid;
	}
	public String getSnstype() {
		return snstype;
	}
	public void setSnstype(String snstype) {
		this.snstype = snstype;
	}
	public char getActive() {
		return active;
	}
	public void setActive(char active) {
		this.active = active;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
}
