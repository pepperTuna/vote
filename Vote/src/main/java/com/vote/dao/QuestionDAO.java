package com.vote.dao;

import java.util.List;

import com.vote.domain.QuestionVO;

public interface QuestionDAO {
	
	  public void createQuestion(QuestionVO vo) throws Exception;
	  
	  public List<QuestionVO> readQuestion(Integer v_idx) throws Exception;
	  
	  public void updateQuestion(QuestionVO vo) throws Exception;
	  
	  public void deleteQuestion(QuestionVO vo) throws Exception;
	  
	  public void deleteChoice(QuestionVO vo) throws Exception;
/*	  
	  public void deleteQuestion(Integer v_idx, Integer q_no) throws Exception;
	  
	  public void deleteChoice(Integer v_idx, Integer q_no, Integer c_no) throws Exception;
*/

}
