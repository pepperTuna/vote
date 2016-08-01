package com.vote.dao;

import com.vote.domain.ResultVO;

public interface ResultDAO {

	public void createResult(ResultVO vo) throws Exception;
	
	public void readResult(ResultVO vo) throws Exception;
	
	public void updateResult(ResultVO vo) throws Exception;
	
	public void deleteResult(ResultVO vo) throws Exception;

}
