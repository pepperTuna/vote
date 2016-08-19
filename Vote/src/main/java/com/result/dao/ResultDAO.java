package com.result.dao;

import java.util.List;

import com.result.domain.ResultVO;

public interface ResultDAO {
	public void createResult(ResultVO vo);
	public List<ResultVO> readResult(int vidx);
}
