package com.vote.domain;

public class VoteQuestionVO {

	private Integer vIdx;
	private Integer qNo;
	private Integer cNo;
	private String content;
	private String attach;
	private String attachType;
	

	public Integer getvIdx() {
		return vIdx;
	}


	public void setvIdx(Integer vIdx) {
		this.vIdx = vIdx;
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


	public String getAttachType() {
		return attachType;
	}


	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}


	@Override
	public String toString() {
		return "QuestionVO [vIdx=" + vIdx + ", qNo=" + qNo + ", cNo="
				+ cNo + ", content=" + content + ", attach=" + attach
				+ ", attachType=" + attachType + "]";
	}
}
