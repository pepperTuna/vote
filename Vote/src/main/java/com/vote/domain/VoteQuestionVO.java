package com.vote.domain;

public class VoteQuestionVO {

	private Integer V_IDX;
	private Integer Q_NO;
	private Integer C_NO;
	private String CONTENT;
	private String ATTACH;
	private String ATTACH_TYPE;
	
	
	public Integer getV_IDX() {
		return V_IDX;
	}

	public void setV_IDX(Integer v_IDX) {
		V_IDX = v_IDX;
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

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public String getATTACH() {
		return ATTACH;
	}

	public void setATTACH(String aTTACH) {
		ATTACH = aTTACH;
	}

	public String getATTACH_TYPE() {
		return ATTACH_TYPE;
	}

	public void setATTACH_TYPE(String aTTACH_TYPE) {
		ATTACH_TYPE = aTTACH_TYPE;
	}

	@Override
	public String toString() {
		return "QuestionVO [V_IDX=" + V_IDX + ", Q_NO=" + Q_NO + ", C_NO="
				+ C_NO + ", CONTENT=" + CONTENT + ", ATTACH=" + ATTACH
				+ ", ATTACH_TYPE=" + ATTACH_TYPE + "]";
	}
}
