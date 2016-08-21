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
	public List<VoteVO> readVoteListWithPaging(int page, String writer){
		return dao.readVoteListWithPaging(page, writer);
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
	public int createVote(HttpServletRequest request) throws Exception {
		VoteVO voteVo = new VoteVO();
		voteVo.setVtitle(request.getParameter("vote_text"));
		voteVo.setVwriter("noname");

		int idx = dao.createVote(voteVo);
		return idx;
	}

}
