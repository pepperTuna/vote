package com.result.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.result.dao.ResultDAO;
import com.result.domain.ResultVO;

@Service
public class ResultServiceImpl implements ResultService{
	
	@Autowired
	ResultDAO dao;
	
	public List<ResultVO> readResult(int vIdx){
		return dao.readResult(vIdx);
	}
}
