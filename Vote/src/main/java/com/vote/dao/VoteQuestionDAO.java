package com.vote.dao;

import java.util.List;

import com.vote.domain.VoteQuestionVO;

public interface VoteQuestionDAO {
	
	  public void createQuestion(VoteQuestionVO vo) throws Exception;
	  
	  public List<VoteQuestionVO> readQuestion(Integer v_idx) throws Exception;
	  
	  public void updateQuestion(VoteQuestionVO vo) throws Exception;
	  
	  public void deleteQuestion(VoteQuestionVO vo) throws Exception;
	  
	  public void deleteChoice(VoteQuestionVO vo) throws Exception;
/*	  
	  public void deleteQuestion(Integer v_idx, Integer q_no) throws Exception;
	  
	  public void deleteChoice(Integer v_idx, Integer q_no, Integer c_no) throws Exception;
*/

}
