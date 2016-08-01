package com.vote.dao;

import java.util.List;
import com.vote.domain.VoteVO;

public interface VoteDAO {

	  public void createVote(VoteVO vo) throws Exception;
	  
	  public VoteVO readVote(Integer v_idx) throws Exception;
	  
	  public List<VoteVO> readVoteList(String v_writer) throws Exception;

	  public void updateVote(VoteVO vo) throws Exception;

	  public void deleteVote(Integer v_idx) throws Exception;
}
