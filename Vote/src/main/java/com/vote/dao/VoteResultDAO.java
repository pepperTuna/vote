package com.vote.dao;

import com.vote.domain.VoteResultVO;

public interface VoteResultDAO {

	public void createResult(VoteResultVO vo) throws Exception;
	
	public void readResult(VoteResultVO vo) throws Exception;
	
	public void updateResult(VoteResultVO vo) throws Exception;
	
	public void deleteResult(VoteResultVO vo) throws Exception;

}
