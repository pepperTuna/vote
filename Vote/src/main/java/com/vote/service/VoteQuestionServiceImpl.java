package com.vote.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
	public void createQuestion(HttpServletRequest request, String uploadPath, int idx) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		int questionLen = multipartRequest.getParameter("vote_length")!=null ? Integer.parseInt(multipartRequest.getParameter("vote_length")) : 0;
		String choiceLen = multipartRequest.getParameter("choice_length").toString();
		String[] choice = choiceLen.split("\\|");
		
		System.out.println("LEN==========================");
		System.out.println(questionLen + " /////////////// "+choiceLen);
		System.out.println("LEN==========================");

		for (int i = 0; i < questionLen; i++) {
			
			String questionText = "question-"+(i+1);
			questionText = multipartRequest.getParameter(questionText);
			
			for (int j = 0; j <= Integer.parseInt(choice[i]); j++) {				
				VoteQuestionVO vo = new VoteQuestionVO();
				String contentText = "";
				
				if(j==0){
					contentText = questionText;
				}else{
					String choiceText = "choice-text-" + (i+1) + "-" + (j);
					
					choiceText = multipartRequest.getParameter(choiceText);
					String choiceFile = "choice-file-" + (i+1) + "-" + (j);
					String uploadedFilePath = null;
					MultipartFile file = multipartRequest.getFile(choiceFile);
	
					if (file != null) {
						
						if (!file.isEmpty()) {
							
						}
					}
					contentText = choiceText;					
				}
				
				vo.setVidx(idx);
				vo.setQno(i+1);
				vo.setCno(j);
				vo.setContent(contentText != null ? contentText : "");
				dao.createQuestion(vo);
			}
		}
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