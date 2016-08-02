package com.vote.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.vote.dao.VoteDAO;
import com.vote.domain.VoteVO;

@Service
public class VoteServiceImpl implements VoteService {

	@Inject
	private VoteDAO dao;

	@Override
	public VoteVO readVote(Integer v_idx) throws Exception {
		return dao.readVote(v_idx);
	}

	@Override
	public List<VoteVO> listVote() throws Exception {
		return dao.listVote();
	}

	@Override
	public void updateVote(VoteVO vo) throws Exception {
		dao.updateVote(vo);
	}

	@Override
	public void deleteVote(Integer v_idx) throws Exception {
		dao.deleteVote(v_idx);
	}

	@Override
	public void createVote(HttpServletRequest request) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		int questionLen = multipartRequest.getParameter("vote_length")!=null ? Integer.parseInt(multipartRequest.getParameter("vote_length")) : 0;
		String choiceLen = multipartRequest.getParameter("choice_length").toString();
		String[] choice = choiceLen.split("\\|");

		for (int i = 0; i < questionLen; i++) {

			for (int j = 0; j < Integer.parseInt(choice[i]); j++) {
				
				
				String choiceText = "choice-text-" + (i+1) + "-" + (j+1);
				String choiceFile = "choice-file-" + (i+1) + "-" + (j+1);
				String uploadedFilePath = null;
				MultipartFile file = multipartRequest.getFile(choiceFile);

				if (file != null) {
					
					if (!file.isEmpty()) {
						
					}
				}
			}
		}
		
		
	}

}
