package com.vote.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.vote.dao.VoteDAO;
import com.vote.domain.PageMaker;
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
	public void deleteVote(Integer v_idx) throws Exception {
		dao.deleteVote(v_idx);
	}

	@Override
	public int createVote(HttpServletRequest request) throws Exception {
		VoteVO voteVo = new VoteVO();
		voteVo.setVtitle(request.getParameter("vote_text"));
		voteVo.setVwriter(request.getParameter("userid"));

		int idx = dao.createVote(voteVo);
		return idx;
	}
	
	@Override
	public List<VoteVO> readVoteListWithPaging(PageMaker pageMaker){
		int totalCount = dao.getTotalVote(pageMaker.getWriter());

		pageMaker.setTotalCount(totalCount);
		pageMaker.makePagingInfo();
		return dao.readVoteListWithPaging(pageMaker);
	}
}
