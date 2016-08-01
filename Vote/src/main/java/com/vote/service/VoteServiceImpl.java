package com.vote.service;

import java.util.List;
import javax.inject.Inject;
import com.vote.dao.VoteDAO;
import com.vote.domain.VoteVO;

public class VoteServiceImpl implements VoteService {

	@Inject
	private VoteDAO dao;
	
	@Override
	public void createVote(VoteVO vo) throws Exception {
		dao.createVote(vo);
	}

	@Override
	public VoteVO readVote(Integer v_idx) throws Exception {
		return dao.readVote(v_idx);
	}

	@Override
	public List<VoteVO> readVoteList(String v_writer) throws Exception {
		return dao.readVoteList(v_writer);
	}

	@Override
	public void updateVote(VoteVO vo) throws Exception {
		dao.updateVote(vo);
	}

	@Override
	public void deleteVote(Integer v_idx) throws Exception {
		dao.deleteVote(v_idx);
	}

}
