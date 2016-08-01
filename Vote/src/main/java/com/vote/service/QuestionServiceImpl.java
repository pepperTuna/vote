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

import com.vote.dao.QuestionDAO;
import com.vote.domain.QuestionVO;

@Service
public class QuestionServiceImpl implements QuestionService {
private static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);

	@Inject
	private QuestionDAO dao;

	@Override
	public void createQuestion(QuestionVO vo) throws Exception {
		dao.createQuestion(vo);
	}
	
	@Override
	public List<QuestionVO> readQuestion(Integer v_idx) throws Exception {
		return dao.readQuestion(v_idx);
	}
	
	@Override
	public void updateQuestion(QuestionVO vo) throws Exception {
		dao.updateQuestion(vo);	
	}
	
	@Override
	public void deleteQuestion(QuestionVO vo) throws Exception {
		dao.deleteQuestion(vo);
	}
	
	@Override
	public void deleteChoice(QuestionVO vo) throws Exception {
		dao.deleteChoice(vo);
	}
		
	@Override
	public void uploadForm(MultipartHttpServletRequest request, String uploadPath) throws Exception {
	      
		int questionLen = request.getParameter("vote_length")!=null ? Integer.parseInt(request.getParameter("vote_length")) : 0;
		String choiceLen = request.getParameter("choice_length").toString();
		String[] choice = choiceLen.split("\\|");
	
		for (int i = 0; i < questionLen; i++) {
	
			for (int j = 0; j < Integer.parseInt(choice[i]); j++) {
	
				String choiceFile = "choice-file-" + (i+1) + "-" + (j+1);
				MultipartFile file = request.getFile(choiceFile);
	
				if (file != null) {
	   
					if (!file.isEmpty()) {
	
						logger.info("originalName: " + file.getOriginalFilename());
						logger.info("size: " + file.getSize());
						logger.info("contentType: " + file.getContentType());
	  
					  //uploadFile(file.getOriginalFilename(), file.getBytes());
					  uploadFile(choiceFile + "_" + file.getOriginalFilename() ,file.getBytes(), uploadPath);
					  
					  //db
					}
				}
			}
		}
	}
	
	@Override
	public void uploadFile(String originalName, byte[] fileData, String uploadPath) throws Exception {
	      
		UUID uid = UUID.randomUUID();
	
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
	      
	}
}