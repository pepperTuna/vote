package com.vote.dao;

import java.util.List;
import com.vote.domain.VoteVO;

public interface VoteDAO {

	  public int createVote(VoteVO vo) throws Exception;
	  
	  public VoteVO readVote(Integer v_idx) throws Exception;
	  
	  public List<VoteVO> listVote() throws Exception;

	  public List<VoteVO> readVoteListWithPaging(int page, String writer);
	  
	  public int updateVote(VoteVO vo) throws Exception;

	  public void deleteVote(Integer v_idx) throws Exception;
}
