package com.vote.domain;

public class VoteQuestionVO {

	private Integer vidx;
	private Integer qno;
	private Integer cno;
	private String content;
	private String attach;
	private String attachtype;
	

	public Integer getVidx() {
		return vidx;
	}


	public void setVidx(Integer vidx) {
		this.vidx = vidx;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAttach() {
		return attach;
	}


	public void setAttach(String attach) {
		this.attach = attach;
	}


	public String getAttachtype() {
		return attachtype;
	}


	public void setAttachtype(String attachtype) {
		this.attachtype = attachtype;
	}


	@Override
	public String toString() {
		return "QuestionVO [V_IDX=" + vidx + ", Q_NO=" + qno + ", C_NO="
				+ cno + ", CONTENT=" + content + ", ATTACH=" + attach
				+ ", ATTACH_TYPE=" + attachtype + "]";
	}
}
