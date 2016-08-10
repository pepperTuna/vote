package com.vote.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vote.domain.VoteVO;

public interface VoteService {

	public VoteVO readVote(Integer v_idx) throws Exception;
	
	public List<VoteVO> listVote() throws Exception;

	public void updateVote(VoteVO vo) throws Exception;

	public void deleteVote(Integer v_idx) throws Exception;

	public int createVote(HttpServletRequest request) throws Exception;
	
}
