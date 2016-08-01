package com.vote.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vote.domain.QuestionVO;

public interface QuestionService {
	
	  public void createQuestion(QuestionVO vo) throws Exception;
	  
	  public List<QuestionVO> readQuestion(Integer v_idx) throws Exception;
	  
	  public void updateQuestion(QuestionVO vo) throws Exception;
	  
	  public void deleteQuestion(QuestionVO vo) throws Exception;
	  
	  public void deleteChoice(QuestionVO vo) throws Exception; 
	  
	  public void uploadForm(MultipartHttpServletRequest request, String uploadPath) throws Exception;
	   
	  public void uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception;
   

}