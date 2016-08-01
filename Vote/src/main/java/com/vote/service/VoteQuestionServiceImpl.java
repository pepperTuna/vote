package com.vote.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vote.dao.VoteQuestionDAO;
import com.vote.domain.VoteQuestionVO;

@Service
public class VoteQuestionServiceImpl implements VoteQuestionService {

	private static final Logger logger = LoggerFactory.getLogger(VoteQuestionServiceImpl.class);

	@Inject
	private VoteQuestionDAO dao;

	@Override
	public void createQuestion(VoteQuestionVO vo) throws Exception {
		dao.createQuestion(vo);
	}
	
	@Override
	public List<VoteQuestionVO> readQuestion(Integer v_idx) throws Exception {
		return dao.readQuestion(v_idx);
	}
	
	@Override
	public void updateQuestion(VoteQuestionVO vo) throws Exception {
		dao.updateQuestion(vo);	
	}
	
	@Override
	public void deleteQuestion(VoteQuestionVO vo) throws Exception {
		dao.deleteQuestion(vo);
	}
	
	@Override
	public void deleteChoice(VoteQuestionVO vo) throws Exception {
		dao.deleteChoice(vo);
	}
		
	@Override
	public String uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
	      
		UUID uid = UUID.randomUUID();
	
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		return uploadPath + savedName;
	      
	}
}