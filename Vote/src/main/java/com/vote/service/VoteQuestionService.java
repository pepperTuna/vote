package com.vote.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vote.domain.VoteQuestionVO;

public interface VoteQuestionService {
	
	  public void createQuestion(VoteQuestionVO vo) throws Exception;
	  
	  public List<VoteQuestionVO> readQuestion(Integer v_idx) throws Exception;
	  
	  public void updateQuestion(VoteQuestionVO vo) throws Exception;
	  
	  public void deleteQuestion(VoteQuestionVO vo) throws Exception;
	  
	  public void deleteChoice(VoteQuestionVO vo) throws Exception; 
	  
	  public void uploadForm(MultipartHttpServletRequest request, String uploadPath) throws Exception;
	   
	  public void uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception;
   

}